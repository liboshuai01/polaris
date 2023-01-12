package com.liboshuai.polaris.security.controller;

import cn.hutool.core.util.RandomUtil;
import com.alibaba.fastjson.JSONObject;
import com.liboshuai.polaris.common.domain.Md5Util;
import com.liboshuai.polaris.common.domain.ResponseResult;
import com.liboshuai.polaris.common.utils.RandImageUtil;
import com.liboshuai.polaris.common.utils.RedisUtil;
import com.liboshuai.polaris.security.query.LoginQuery;
import com.liboshuai.polaris.security.service.LoginService;
import com.liboshuai.polaris.security.vo.SysUserInfoVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

/**
 * @Auther: Bernardo
 * @Date: 2023/1/2 00:06
 * @Description: 登录相关功能
 */
@Slf4j
@RestController
@NoArgsConstructor
@Api(tags = "登录相关功能", value = "LoginController")
public class LoginController {

    private LoginService loginService;

    @Resource
    private RedisUtil redisUtil;

    @Autowired
    public LoginController(LoginService loginService) {
        this.loginService = loginService;
    }

    private final String BASE_CHECK_CODES = "qwertyuiplkjhgfdsazxcvbnmQWERTYUPLKJHGFDSAZXCVBNM1234567890";
    private final String signatureSecret = "dd05f1c54d63749eda95f9fa6d49v442a";


    @ApiOperation(value = "登录", httpMethod = "POST")
    @PostMapping("/login")
    public ResponseResult<SysUserInfoVO> login(@Valid @RequestBody LoginQuery loginQuery) {
        log.info("-------用户{}进行登录操作-------", JSONObject.toJSONString(loginQuery));
        return loginService.login(loginQuery);
    }

    @ApiOperation(value = "获取当前登录用户信息", httpMethod = "GET")
    @GetMapping("/info")
    public ResponseResult<?> info() {
        log.info("-----进入info接口-----");
        // todo: 根据用户名admin查询出下面的数据
        // {"code":200,"message":"操作成功","data":{"roles":["超级管理员"],"icon":"http://macro-oss.oss-cn-shenzhen.aliyuncs.com/mall/images/20180607/timg.jpg","menus":[{"id":1,"parentId":0,"createTime":"2020-02-02T06:50:36.000+00:00","title":"商品","level":0,"sort":0,"name":"pms","icon":"product","hidden":0},{"id":2,"parentId":1,"createTime":"2020-02-02T06:51:50.000+00:00","title":"商品列表","level":1,"sort":0,"name":"product","icon":"product-list","hidden":0},{"id":3,"parentId":1,"createTime":"2020-02-02T06:52:44.000+00:00","title":"添加商品","level":1,"sort":0,"name":"addProduct","icon":"product-add","hidden":0},{"id":4,"parentId":1,"createTime":"2020-02-02T06:53:51.000+00:00","title":"商品分类","level":1,"sort":0,"name":"productCate","icon":"product-cate","hidden":0},{"id":5,"parentId":1,"createTime":"2020-02-02T06:54:51.000+00:00","title":"商品类型","level":1,"sort":0,"name":"productAttr","icon":"product-attr","hidden":0},{"id":6,"parentId":1,"createTime":"2020-02-02T06:56:29.000+00:00","title":"品牌管理","level":1,"sort":0,"name":"brand","icon":"product-brand","hidden":0},{"id":7,"parentId":0,"createTime":"2020-02-02T08:54:07.000+00:00","title":"订单","level":0,"sort":0,"name":"oms","icon":"order","hidden":0},{"id":8,"parentId":7,"createTime":"2020-02-02T08:55:18.000+00:00","title":"订单列表","level":1,"sort":0,"name":"order","icon":"product-list","hidden":0},{"id":9,"parentId":7,"createTime":"2020-02-02T08:56:46.000+00:00","title":"订单设置","level":1,"sort":0,"name":"orderSetting","icon":"order-setting","hidden":0},{"id":10,"parentId":7,"createTime":"2020-02-02T08:57:39.000+00:00","title":"退货申请处理","level":1,"sort":0,"name":"returnApply","icon":"order-return","hidden":0},{"id":11,"parentId":7,"createTime":"2020-02-02T08:59:40.000+00:00","title":"退货原因设置","level":1,"sort":0,"name":"returnReason","icon":"order-return-reason","hidden":0},{"id":12,"parentId":0,"createTime":"2020-02-04T08:18:00.000+00:00","title":"营销","level":0,"sort":0,"name":"sms","icon":"sms","hidden":0},{"id":13,"parentId":12,"createTime":"2020-02-04T08:19:22.000+00:00","title":"秒杀活动列表","level":1,"sort":0,"name":"flash","icon":"sms-flash","hidden":0},{"id":14,"parentId":12,"createTime":"2020-02-04T08:20:16.000+00:00","title":"优惠券列表","level":1,"sort":0,"name":"coupon","icon":"sms-coupon","hidden":0},{"id":16,"parentId":12,"createTime":"2020-02-07T08:22:38.000+00:00","title":"品牌推荐","level":1,"sort":0,"name":"homeBrand","icon":"product-brand","hidden":0},{"id":17,"parentId":12,"createTime":"2020-02-07T08:23:14.000+00:00","title":"新品推荐","level":1,"sort":0,"name":"homeNew","icon":"sms-new","hidden":0},{"id":18,"parentId":12,"createTime":"2020-02-07T08:26:38.000+00:00","title":"人气推荐","level":1,"sort":0,"name":"homeHot","icon":"sms-hot","hidden":0},{"id":19,"parentId":12,"createTime":"2020-02-07T08:28:16.000+00:00","title":"专题推荐","level":1,"sort":0,"name":"homeSubject","icon":"sms-subject","hidden":0},{"id":20,"parentId":12,"createTime":"2020-02-07T08:28:42.000+00:00","title":"广告列表","level":1,"sort":0,"name":"homeAdvertise","icon":"sms-ad","hidden":0},{"id":21,"parentId":0,"createTime":"2020-02-07T08:29:13.000+00:00","title":"权限","level":0,"sort":0,"name":"ums","icon":"ums","hidden":0},{"id":22,"parentId":21,"createTime":"2020-02-07T08:29:51.000+00:00","title":"用户列表","level":1,"sort":0,"name":"admin","icon":"ums-admin","hidden":0},{"id":23,"parentId":21,"createTime":"2020-02-07T08:30:13.000+00:00","title":"角色列表","level":1,"sort":0,"name":"role","icon":"ums-role","hidden":0},{"id":24,"parentId":21,"createTime":"2020-02-07T08:30:53.000+00:00","title":"菜单列表","level":1,"sort":0,"name":"menu","icon":"ums-menu","hidden":0},{"id":25,"parentId":21,"createTime":"2020-02-07T08:31:13.000+00:00","title":"资源列表","level":1,"sort":0,"name":"resource","icon":"ums-resource","hidden":0}],"username":"admin"}}
        return ResponseResult.success();
    }

    /**
     * 后台生成图形验证码 ：有效
     */
    @ApiOperation("获取验证码")
    @GetMapping(value = "/randomImage/{key}")
    public ResponseResult<String> randomImage(@PathVariable("key") String key) {
        try {
            //生成验证码
            String code = RandomUtil.randomString(BASE_CHECK_CODES, 4);
            //存到redis中
            String lowerCaseCode = code.toLowerCase();

            //update-begin-author:taoyan date:2022-9-13 for: VUEN-2245 【漏洞】发现新漏洞待处理20220906
            // 加入密钥作为混淆，避免简单的拼接，被外部利用，用户自定义该密钥即可
            String origin = lowerCaseCode + key + signatureSecret;
            String realKey = Md5Util.md5Encode(origin, "utf-8");
            //update-end-author:taoyan date:2022-9-13 for: VUEN-2245 【漏洞】发现新漏洞待处理20220906

            redisUtil.set(realKey, lowerCaseCode, 60);
            log.info("获取验证码，Redis key = {}，checkCode = {}", realKey, code);
            //返回前端
            String base64 = RandImageUtil.generate(code);
            return ResponseResult.success(base64);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            return ResponseResult.fail("获取验证码失败,请检查redis配置!");
        }
    }

}
