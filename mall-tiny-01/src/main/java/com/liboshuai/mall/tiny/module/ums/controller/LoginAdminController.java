package com.liboshuai.mall.tiny.module.ums.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.liboshuai.mall.tiny.common.constants.RedisConstant;
import com.liboshuai.mall.tiny.common.constants.ShiroConstant;
import com.liboshuai.mall.tiny.common.enums.ResponseCode;
import com.liboshuai.mall.tiny.common.enums.UserStatusEnum;
import com.liboshuai.mall.tiny.compone.response.ResponseResult;
import com.liboshuai.mall.tiny.module.ums.domain.entity.UmsAdmin;
import com.liboshuai.mall.tiny.module.ums.domain.dto.UmsAdminDTO;
import com.liboshuai.mall.tiny.module.ums.domain.vo.UmsAdminVO;
import com.liboshuai.mall.tiny.module.ums.service.UmsAdminService;
import com.liboshuai.mall.tiny.shiro.cache.RedisClient;
import com.liboshuai.mall.tiny.shiro.jwt.JwtUtil;
import com.liboshuai.mall.tiny.utils.HttpClientUtil;
import com.liboshuai.mall.tiny.utils.SignUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URLEncoder;
import java.time.LocalDateTime;
import java.util.Enumeration;
import java.util.Objects;

/**
 * @Author: liboshuai
 * @Date: 2022-09-10 01:27
 * @Description: 用户登录controller
 */
@Api(tags = "用户登录入口", value = "LoginAdminController")
@Slf4j
@RestController
public class LoginAdminController {

    @Value("${config.refreshToken-expireTime}")
    private String refreshTokenExpireTime;

    @Autowired
    private RedisClient redis;

    @Autowired
    private HttpServletRequest request;

    @Autowired
    private UmsAdminService umsAdminService;


    /**
     * 用户注册
     */
    @ApiOperation(value = "注册", httpMethod = "POST")
    @PostMapping("/register")
    public ResponseResult<?> register(@RequestBody UmsAdminVO umsAdminVo) {
        UmsAdminDTO umsAdminDTO = new UmsAdminDTO();
        BeanUtils.copyProperties(umsAdminVo, umsAdminDTO);
        String username = umsAdminDTO.getUsername();
        String password = umsAdminDTO.getPassword();
        if (Objects.nonNull(password)) {
            int saltCount = ShiroConstant.HASH_INTERATIONS;
            String salt = ByteSource.Util.bytes(username).toString();
            String enPassword = new SimpleHash(ShiroConstant.ALGORITH_NAME, password,
                    salt, saltCount).toString();
            umsAdminDTO.setPassword(enPassword);
            umsAdminDTO.setSalt(salt);
            umsAdminDTO.setSaltCount(saltCount);
        }
        umsAdminDTO.setStatus(UserStatusEnum.Enable.getCode());
        UmsAdmin umsAdmin = new UmsAdmin();
        BeanUtils.copyProperties(umsAdminDTO, umsAdmin);
        log.info("日志umsAdmin:{}", JSONObject.toJSONString(umsAdmin));
        umsAdminService.save(umsAdmin);
        return ResponseResult.success("注册成功");
    }


    /**
     * 用户登录
     */
    @ApiOperation(value = "登录", httpMethod = "POST")
    @PostMapping("/login")
    public ResponseResult<?> login(@RequestParam String username, @RequestParam String password, HttpServletResponse response) {
        if (StringUtils.isBlank(username) || StringUtils.isBlank(password)) {
            return ResponseResult.fail(ResponseCode.USERNAME_PASSWORD_NULL);
        }
        UmsAdminDTO umsAdminDTO = umsAdminService.findByUserName(username);
        // todo: 临时日志，待删除
        log.info("umsAdminDTO等于：{}", JSONObject.toJSONString(umsAdminDTO));
        if (Objects.isNull(umsAdminDTO)) {
            return ResponseResult.fail(ResponseCode.INCORRECT_CREDENTIALS);
        }
        if (Objects.isNull(umsAdminDTO.getSalt()) || Objects.isNull(umsAdminDTO.getSaltCount())) {
            return ResponseResult.fail(ResponseCode.SALT_IS_NOT_EXISTED);
        }
        String enPassword = new SimpleHash(ShiroConstant.ALGORITH_NAME, password,
                umsAdminDTO.getSalt(), umsAdminDTO.getSaltCount()).toString();
        if (!Objects.equals(umsAdminDTO.getPassword(), enPassword)) {
            return ResponseResult.fail(ResponseCode.INCORRECT_CREDENTIALS);
        }
        // 清除可能存在的shiro权限信息缓存
        if (redis.hasKey(RedisConstant.PREFIX_SHIRO_CACHE + username)) {
            redis.del(RedisConstant.PREFIX_SHIRO_CACHE + username);
        }
        // 设置RefreshToken，时间戳为当前时间戳，直接设置即可(不用先删后设，会覆盖已有的RefreshToken)
        String currentTimeMillis = String.valueOf(System.currentTimeMillis());
        redis.set(RedisConstant.PREFIX_SHIRO_REFRESH_TOKEN + username, currentTimeMillis,
                Integer.parseInt(refreshTokenExpireTime));
        // 从Header中Authorization返回AccessToken，时间戳为当前时间戳
        String token = JwtUtil.generateJwt(username, currentTimeMillis);
        response.setHeader(ShiroConstant.AUTHORIZATION, token);
        response.setHeader(ShiroConstant.ACCESS_CONTROL_EXPOSE_HEADERS, ShiroConstant.AUTHORIZATION);
        // 更新登录时间
        umsAdminDTO.setLoginTime(LocalDateTime.now());
        LambdaUpdateWrapper<UmsAdmin> umsAdminLambdaUpdateWrapper = new LambdaUpdateWrapper<>();
        umsAdminLambdaUpdateWrapper.eq(UmsAdmin::getId, umsAdminDTO.getId());
        umsAdminLambdaUpdateWrapper.set(UmsAdmin::getLoginTime, umsAdminDTO.getLoginTime());
        umsAdminService.update(umsAdminLambdaUpdateWrapper);
        return ResponseResult.success("登录成功");


    }

    /**
     * 退出
     */
    @ApiOperation(value = "退出", httpMethod = "POST")
    @PostMapping("/logout")
    public ResponseResult<?> logout() {
        try {
            String token = "";
            // 获取头部信息
            Enumeration<String> headerNames = request.getHeaderNames();
            while (headerNames.hasMoreElements()) {
                String key = headerNames.nextElement();
                if (ShiroConstant.AUTHORIZATION.equalsIgnoreCase(key)) {
                    token = request.getHeader(key);
                }
            }
            // 效验 token
            if (StringUtils.isBlank(token)) {
                return ResponseResult.fail(ResponseCode.FAILED);
            }
            String username = JwtUtil.getClaim(token, ShiroConstant.USERNAME);
            if (StringUtils.isBlank(username)) {
                return ResponseResult.fail(ResponseCode.TOKEN_EXPIRE_OR_ERROR, ResponseCode.FAILED.getMessage());
            }
            // 清除shiro权限信息缓存
            if (redis.hasKey(RedisConstant.PREFIX_SHIRO_CACHE + username)) {
                redis.del(RedisConstant.PREFIX_SHIRO_CACHE + username);
            }
            // 清除RefreshToken
            redis.del(RedisConstant.PREFIX_SHIRO_REFRESH_TOKEN + username);
            return ResponseResult.success();
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseResult.fail(ResponseCode.FAILED, e.getMessage());
        }
    }

    /**
     * 用于给微信验证token
     * @param request
     * @param response
     * */
    @ApiOperation(value = "用于给微信验证token", httpMethod = "GET")
    @RequestMapping("/checkToken")
    public String checkToken(HttpServletRequest request,HttpServletResponse response) throws IOException {
        // 微信加密签名
        String signature = request.getParameter("signature");
        // 时间戳
        String timestamp = request.getParameter("timestamp");
        // 随机数
        String nonce = request.getParameter("nonce");
        // 随机字符串
        String echostr = request.getParameter("echostr");
        if (SignUtil.checkSignature(signature, timestamp, nonce)) {
            System.out.println("校验token成功");
            return echostr;
        }else{
            System.out.println("校验token不成功");
            return  null;
        }
    }

    /**
     * 公众号微信登录授权
     */
    @ApiOperation(value = "公众号微信登录授权", httpMethod = "GET")
    @RequestMapping("/wxLogin")
    public void wxLogin(HttpServletResponse response) throws IOException {
        //这个url的域名必须在公众号中进行注册验证，这个地址是成功后的回调地址
        String backUrl = "http://7ca0c439f61c.ngrok.io/callback";//使用自己的域名
        // 第一步：用户同意授权，获取code
        //请求地址  snsapi_base   snsapi_userinfo
        String url = "https://open.weixin.qq.com/connect/oauth2/authorize" +
                "?appid=" + HttpClientUtil.APPID +
                "&redirect_uri=" + URLEncoder.encode(backUrl,"utf-8") +
                "&response_type=code" +
                "&scope=snsapi_userinfo" +
                "&state=STATE#wechat_redirect";
        log.info("forward重定向地址{" + url + "}");
        //必须重定向，否则不能成功
        response.sendRedirect(url);
    }

    /**
     * 公众号微信登录授权回调函数
     */
    @ApiOperation(value = "公众号微信登录授权回调函数", httpMethod = "GET")
    @RequestMapping("/callback")
    public ResponseResult<?> callback(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try{
            /*start 获取微信用户基本信息*/
            String code = req.getParameter("code");
            //第二步：通过code换取网页授权access_token
            String url = "https://api.weixin.qq.com/sns/oauth2/access_token?"
                    + "appid=" + HttpClientUtil.APPID
                    + "&secret=" + HttpClientUtil.APPSECRET
                    + "&code=" + code
                    + "&grant_type=authorization_code";
            System.out.println(url);

            String result = HttpClientUtil.doGet(url);
            JSONObject jsonObject = JSON.parseObject(result);

            /*
         {   "access_token":"ACCESS_TOKEN",
            "expires_in":7200,
            "refresh_token":"REFRESH_TOKEN",
            "openid":"OPENID",
            "scope":"SCOPE"
           }
         */
            String openid = jsonObject.getString("openid");
            String access_token = jsonObject.getString("access_token");

            //第三步验证access_token是否失效；
            String chickUrl = "https://api.weixin.qq.com/sns/auth?access_token="
                    + access_token + "&openid=" + openid;
            String resultInfo = HttpClientUtil.doGet(chickUrl);
            JSONObject chickuserInfo = JSON.parseObject(resultInfo);
            System.out.println(chickuserInfo.toString());
            if (!"0".equals(chickuserInfo.getString("errcode"))) {
                String refreshInfo1 = HttpClientUtil.doGet(chickUrl);
                JSONObject refreshInfo = JSON.parseObject(refreshInfo1);
             /*
              { "access_token":"ACCESS_TOKEN",
                "expires_in":7200,
                "refresh_token":"REFRESH_TOKEN",
                "openid":"OPENID",
                "scope":"SCOPE" }
             */
                access_token = refreshInfo.getString("access_token");
            }

            // 第四步：拉取用户信息
            String infoUrl = "https://api.weixin.qq.com/sns/userinfo?access_token=" + access_token
                    + "&openid=" + openid
                    + "&lang=zh_CN";
            JSONObject userInfo = JSON.parseObject(HttpClientUtil.doGet(infoUrl));
            /*
         {  "openid":" OPENID",
            "nickname": NICKNAME,
            "sex":"1",
            "province":"PROVINCE"
            "city":"CITY",
            "country":"COUNTRY",
            "headimgurl": "http://wx.qlogo.cn/mmopen/g3MonUZtNHkdmzicIlibx6iaFqAc56vxLSUfpb6n5WKSYVY0ChQKkiaJSgQ1dZuTOgvLLrhJbERQQ4eMsv84eavHiaiceqxibJxCfHe/46",
            "privilege":[ "PRIVILEGE1" "PRIVILEGE2"     ],
            "unionid": "o6_bmasdasdsad6_2sgVt7hMZOPfL"
           }
         */
            System.out.println(userInfo.getString("openid") + ":" + userInfo.getString("nickname") +":" + userInfo.getString("sex"));
        }catch (Exception e){
            e.printStackTrace();
            return ResponseResult.fail();
        }
        return ResponseResult.success();
    }

}
