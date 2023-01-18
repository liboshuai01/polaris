package com.liboshuai.polaris.security.controller;

import cn.hutool.core.util.RandomUtil;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.liboshuai.polaris.common.constants.CommonConstant;
import com.liboshuai.polaris.common.constants.SymbolConstant;
import com.liboshuai.polaris.common.domain.Md5Util;
import com.liboshuai.polaris.common.domain.ResponseResult;
import com.liboshuai.polaris.common.utils.RandImageUtil;
import com.liboshuai.polaris.common.utils.RedisUtil;
import com.liboshuai.polaris.common.utils.oConvertUtils;
import com.liboshuai.polaris.security.dto.SysUserDTO;
import com.liboshuai.polaris.security.entity.SysPermissionEntity;
import com.liboshuai.polaris.security.entity.SysRoleIndexEntity;
import com.liboshuai.polaris.security.query.LoginQuery;
import com.liboshuai.polaris.security.service.*;
import com.liboshuai.polaris.security.utils.PermissionDataUtil;
import com.liboshuai.polaris.security.vo.SysUserInfoVO;
import com.liboshuai.polaris.security.vo.SysUserVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.*;
import java.util.stream.Collectors;

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
    private RedisUtil redisUtil;
    private SysUserService sysUserService;
    private SysDictService sysDictService;
    private SysPermissionService sysPermissionService;
    private SysLogService logService;

    @Autowired
    public LoginController(LoginService loginService, RedisUtil redisUtil, SysUserService sysUserService,
                           SysDictService sysDictService, SysPermissionService sysPermissionService,
                           SysLogService logService) {
        this.loginService = loginService;
        this.redisUtil = redisUtil;
        this.sysUserService = sysUserService;
        this.sysDictService = sysDictService;
        this.sysPermissionService = sysPermissionService;
        this.logService = logService;
    }

    private final String BASE_CHECK_CODES = "qwertyuiplkjhgfdsazxcvbnmQWERTYUPLKJHGFDSAZXCVBNM1234567890";
    private final String signatureSecret = "dd05f1c54d63749eda95f9fa6d49v442a";
    private final Boolean safeMode = false;
    /**
     * 子菜单
     */
    private static final String CHILDREN = "children";


    @ApiOperation(value = "登录", httpMethod = "POST")
    @PostMapping("/login")
    public ResponseResult<SysUserInfoVO> login(@Valid @RequestBody LoginQuery loginQuery) {
        log.info("-------用户{}进行登录操作-------", JSONObject.toJSONString(loginQuery));
        return loginService.login(loginQuery);
    }

    @ApiOperation(value = "获取当前登录用户信息", httpMethod = "GET")
    @GetMapping("/getUserInfo")
    public ResponseResult<?> getUserInfo(HttpServletRequest request) {
        // todo: 从token中获取用户名
        String username = "admin";
        JSONObject obj = new JSONObject();
        if (StringUtils.isNotEmpty(username)) {
            // 根据用户名查询用户信息
            ResponseResult<SysUserDTO> sysUserDTOResponseResult = sysUserService.findUserByName(username);
            if (Objects.isNull(sysUserDTOResponseResult) || !sysUserDTOResponseResult.isSuccess()) {
                return ResponseResult.fail("根据用户名查询用户信息失败");
            }
            SysUserDTO sysUserDTO = sysUserDTOResponseResult.getResult();
            SysUserVO sysUserVO = new SysUserVO();
            BeanUtils.copyProperties(sysUserDTO, sysUserVO);

            //update-begin---author:scott ---date:2022-06-20  for：vue3前端，支持自定义首页-----------
            String version = request.getHeader(CommonConstant.VERSION);
            //update-begin---author:liusq ---date:2022-06-29  for：接口返回值修改，同步修改这里的判断逻辑-----------
            SysRoleIndexEntity roleIndex = sysUserService.getDynamicIndexByUserRole(username, version);
            if (StringUtils.isNotEmpty(version) && roleIndex != null && StringUtils.isNotEmpty(roleIndex.getUrl())) {
                String homePath = roleIndex.getUrl();
                if (!homePath.startsWith(SymbolConstant.SINGLE_SLASH)) {
                    homePath = SymbolConstant.SINGLE_SLASH + homePath;
                }
                sysUserVO.setHomePath(homePath);
            }
            //update-begin---author:liusq ---date:2022-06-29  for：接口返回值修改，同步修改这里的判断逻辑-----------
            //update-end---author:scott ---date::2022-06-20  for：vue3前端，支持自定义首页--------------

            obj.put("userInfo", sysUserVO);
            obj.put("sysAllDictItems", sysDictService.queryAllDictItems());
        }
        return ResponseResult.success(obj);
    }

    /**
     * 后台生成图形验证码 ：有效
     */
    @ApiOperation(value = "获取图形验证码", httpMethod = "GET")
    @GetMapping(value = "/randomImage/{_t}")
    public ResponseResult<String> randomImage(@PathVariable("_t") String key) {
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
            return ResponseResult.success("获取图形验证码成功",base64);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            return ResponseResult.fail("获取验证码失败,请检查redis配置!");
        }
    }

    /**
     * 【vue3专用】获取
     * 1、查询用户拥有的按钮/表单访问权限
     * 2、所有权限 (菜单权限配置)
     * 3、系统安全模式 (开启则online报表的数据源必填)
     */
    @ApiOperation(value = "查询用户拥有的按钮/表单访问权限", httpMethod = "GET")
    @RequestMapping(value = "/getPermCode", method = RequestMethod.GET)
    public ResponseResult<?> getPermCode() {
        try {
            // todo: 直接获取当前用户
            String username = "admin";
            // 获取当前用户的权限集合
            List<SysPermissionEntity> metaList = sysPermissionService.queryByUser(username);
            // 按钮权限（用户拥有的权限集合）
            List<String> codeList = metaList.stream()
                    .filter((permission) -> CommonConstant.MENU_TYPE_2.equals(permission.getMenuType()) && CommonConstant.STATUS_1.equals(permission.getStatus()))
                    .collect(ArrayList::new, (list, permission) -> list.add(permission.getPerms()), ArrayList::addAll);
            //
            JSONArray authArray = new JSONArray();
            this.getAuthJsonArray(authArray, metaList);
            // 查询所有的权限
            LambdaQueryWrapper<SysPermissionEntity> query = new LambdaQueryWrapper<>();
            query.eq(SysPermissionEntity::getIsDelete, CommonConstant.DEL_FLAG_0);
            query.eq(SysPermissionEntity::getMenuType, CommonConstant.MENU_TYPE_2);
            List<SysPermissionEntity> allAuthList = sysPermissionService.list(query);
            JSONArray allAuthArray = new JSONArray();
            this.getAllAuthJsonArray(allAuthArray, allAuthList);
            JSONObject result = new JSONObject();
            // 所拥有的权限编码
            result.put("codeList", codeList);
            //按钮权限（用户拥有的权限集合）
            result.put("auth", authArray);
            //全部权限配置集合（按钮权限，访问权限）
            result.put("allAuth", allAuthArray);
            // 系统安全模式
            result.put("sysSafeMode", safeMode);
            return ResponseResult.success(result);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            return ResponseResult.fail("查询失败:" + e.getMessage());
        }
    }

    /**
     * 查询用户拥有的菜单权限和按钮权限
     */
    @ApiOperation(value = "查询用户拥有的菜单权限和按钮权限", httpMethod = "GET")
    @RequestMapping(value = "/getUserPermissionByToken", method = RequestMethod.GET)
    //@DynamicTable(value = DynamicTableConstant.SYS_ROLE_INDEX)
    public ResponseResult<?> getUserPermissionByToken(HttpServletRequest request) {
        try {
            //直接获取当前用户不适用前端token
//            LoginUser loginUser = (LoginUser) SecurityUtils.getSubject().getPrincipal();
//            if (oConvertUtils.isEmpty(loginUser)) {
//                return ResponseResult.fail("请登录系统！");
//            }
            String username = "admin";
            List<SysPermissionEntity> metaList = sysPermissionService.queryByUser(username);
            //添加首页路由
            //update-begin-author:taoyan date:20200211 for: TASK #3368 【路由缓存】首页的缓存设置有问题，需要根据后台的路由配置来实现是否缓存
            if (!PermissionDataUtil.hasIndexPage(metaList)) {
                SysPermissionEntity indexMenu = sysPermissionService.list(new LambdaQueryWrapper<SysPermissionEntity>().eq(SysPermissionEntity::getName, "首页")).get(0);
                metaList.add(0, indexMenu);
            }
            //update-end-author:taoyan date:20200211 for: TASK #3368 【路由缓存】首页的缓存设置有问题，需要根据后台的路由配置来实现是否缓存

            //update-begin--Author:zyf Date:20220425  for:自定义首页地址 LOWCOD-1578
            String version = request.getHeader(CommonConstant.VERSION);
            //update-begin---author:liusq ---date:2022-06-29  for：接口返回值修改，同步修改这里的判断逻辑-----------
            SysRoleIndexEntity roleIndex = sysUserService.getDynamicIndexByUserRole(username, version);
            //update-end---author:liusq ---date:2022-06-29  for：接口返回值修改，同步修改这里的判断逻辑-----------
            //update-end--Author:zyf  Date:20220425  for：自定义首页地址 LOWCOD-1578

            if (roleIndex != null) {
                List<SysPermissionEntity> menus = metaList.stream().filter(sysPermission -> "首页".equals(sysPermission.getName())).collect(Collectors.toList());
                //update-begin---author:liusq ---date:2022-06-29  for：设置自定义首页地址和组件----------
                String component = roleIndex.getComponent();
                String routeUrl = roleIndex.getUrl();
                boolean route = roleIndex.isRoute();
                if (oConvertUtils.isNotEmpty(routeUrl)) {
                    menus.get(0).setComponent(component);
                    menus.get(0).setRoute(route);
                    menus.get(0).setUrl(routeUrl);
                } else {
                    menus.get(0).setComponent(component);
                }
                //update-end---author:liusq ---date:2022-06-29  for：设置自定义首页地址和组件-----------
            }

            JSONObject json = new JSONObject();
            JSONArray menujsonArray = new JSONArray();
            this.getPermissionJsonArray(menujsonArray, metaList, null);
            //一级菜单下的子菜单全部是隐藏路由，则一级菜单不显示
            this.handleFirstLevelMenuHidden(menujsonArray);

            JSONArray authjsonArray = new JSONArray();
            this.getAuthJsonArray(authjsonArray, metaList);
            //查询所有的权限
            LambdaQueryWrapper<SysPermissionEntity> query = new LambdaQueryWrapper<>();
            query.eq(SysPermissionEntity::getIsDelete, CommonConstant.DEL_FLAG_0);
            query.eq(SysPermissionEntity::getMenuType, CommonConstant.MENU_TYPE_2);
            //query.eq(SysPermission::getStatus, "1");
            List<SysPermissionEntity> allAuthList = sysPermissionService.list(query);
            JSONArray allauthjsonArray = new JSONArray();
            this.getAllAuthJsonArray(allauthjsonArray, allAuthList);
            //路由菜单
            json.put("menu", menujsonArray);
            //按钮权限（用户拥有的权限集合）
            json.put("auth", authjsonArray);
            //全部权限配置集合（按钮权限，访问权限）
            json.put("allAuth", allauthjsonArray);
            json.put("sysSafeMode", safeMode);
            return ResponseResult.success(json);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            return ResponseResult.fail("查询失败:" + e.getMessage());
        }
    }

    /**
     * 获取访问量
     * @return
     */
    @ApiOperation(value = "获取访问量loginfo", httpMethod = "GET")
    @GetMapping("/loginfo")
    public ResponseResult<JSONObject> loginfo() {
        JSONObject obj = new JSONObject();
        //update-begin--Author:zhangweijian  Date:20190428 for：传入开始时间，结束时间参数
        // 获取一天的开始和结束时间
        Calendar calendar = new GregorianCalendar();
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MILLISECOND, 0);
        Date dayStart = calendar.getTime();
        calendar.add(Calendar.DATE, 1);
        Date dayEnd = calendar.getTime();
        // 获取系统访问记录
        Long totalVisitCount = logService.findTotalVisitCount();
        obj.put("totalVisitCount", totalVisitCount);
        Long todayVisitCount = logService.findTodayVisitCount(dayStart,dayEnd);
        obj.put("todayVisitCount", todayVisitCount);
        Long todayIp = logService.findTodayIp(dayStart,dayEnd);
        //update-end--Author:zhangweijian  Date:20190428 for：传入开始时间，结束时间参数
        obj.put("todayIp", todayIp);
        return ResponseResult.success("登录成功", obj);
    }

    /**
     * 获取访问量
     * @return
     */
    @ApiOperation(value = "获取访问量visitInfo", httpMethod = "GET")
    @GetMapping("/visitInfo")
    public ResponseResult<List<Map<String,Object>>> visitInfo() {
        Calendar calendar = new GregorianCalendar();
        calendar.set(Calendar.HOUR_OF_DAY,0);
        calendar.set(Calendar.MINUTE,0);
        calendar.set(Calendar.SECOND,0);
        calendar.set(Calendar.MILLISECOND,0);
        calendar.add(Calendar.DAY_OF_MONTH, 1);
        Date dayEnd = calendar.getTime();
        calendar.add(Calendar.DAY_OF_MONTH, -7);
        Date dayStart = calendar.getTime();
        List<Map<String,Object>> list = logService.findVisitCount(dayStart, dayEnd);
        return ResponseResult.success(oConvertUtils.toLowerCasePageList(list));
    }

    /**
     * 一级菜单的子菜单全部是隐藏路由，则一级菜单不显示
     * @param jsonArray
     */
    private void handleFirstLevelMenuHidden(JSONArray jsonArray) {
        jsonArray = jsonArray.stream().map(obj -> {
            JSONObject returnObj = new JSONObject();
            JSONObject jsonObj = (JSONObject)obj;
            if(jsonObj.containsKey(CHILDREN)){
                JSONArray childrens = jsonObj.getJSONArray(CHILDREN);
                childrens = childrens.stream().filter(arrObj -> !"true".equals(((JSONObject) arrObj).getString("hidden"))).collect(Collectors.toCollection(JSONArray::new));
                if(childrens==null || childrens.size()==0){
                    jsonObj.put("hidden",true);

                    //vue3版本兼容代码
                    JSONObject meta = new JSONObject();
                    meta.put("hideMenu",true);
                    jsonObj.put("meta", meta);
                }
            }
            return returnObj;
        }).collect(Collectors.toCollection(JSONArray::new));
    }

    /**
     *  获取菜单JSON数组
     * @param jsonArray
     * @param metaList
     * @param parentJson
     */
    private void getPermissionJsonArray(JSONArray jsonArray, List<SysPermissionEntity> metaList, JSONObject parentJson) {
        for (SysPermissionEntity permission : metaList) {
            if (permission.getMenuType() == null) {
                continue;
            }
            String tempPid = permission.getParentId();
            JSONObject json = getPermissionJsonObject(permission);
            if(json==null) {
                continue;
            }
            if (parentJson == null && oConvertUtils.isEmpty(tempPid)) {
                jsonArray.add(json);
                if (!permission.isLeaf()) {
                    getPermissionJsonArray(jsonArray, metaList, json);
                }
            } else if (parentJson != null && oConvertUtils.isNotEmpty(tempPid) && tempPid.equals(parentJson.getString("id"))) {
                // 类型( 0：一级菜单 1：子菜单 2：按钮 )
                if (permission.getMenuType().equals(CommonConstant.MENU_TYPE_2)) {
                    JSONObject metaJson = parentJson.getJSONObject("meta");
                    if (metaJson.containsKey("permissionList")) {
                        metaJson.getJSONArray("permissionList").add(json);
                    } else {
                        JSONArray permissionList = new JSONArray();
                        permissionList.add(json);
                        metaJson.put("permissionList", permissionList);
                    }
                    // 类型( 0：一级菜单 1：子菜单 2：按钮 )
                } else if (permission.getMenuType().equals(CommonConstant.MENU_TYPE_1) || permission.getMenuType().equals(CommonConstant.MENU_TYPE_0)) {
                    if (parentJson.containsKey("children")) {
                        parentJson.getJSONArray("children").add(json);
                    } else {
                        JSONArray children = new JSONArray();
                        children.add(json);
                        parentJson.put("children", children);
                    }

                    if (!permission.isLeaf()) {
                        getPermissionJsonArray(jsonArray, metaList, json);
                    }
                }
            }

        }
    }

    /**
     * 根据菜单配置生成路由json
     * @param permission
     * @return
     */
    private JSONObject getPermissionJsonObject(SysPermissionEntity permission) {
        JSONObject json = new JSONObject();
        // 类型(0：一级菜单 1：子菜单 2：按钮)
        if (permission.getMenuType().equals(CommonConstant.MENU_TYPE_2)) {
            //json.put("action", permission.getPerms());
            //json.put("type", permission.getPermsType());
            //json.put("describe", permission.getName());
            return null;
        } else if (permission.getMenuType().equals(CommonConstant.MENU_TYPE_0) || permission.getMenuType().equals(CommonConstant.MENU_TYPE_1)) {
            json.put("id", permission.getId());
            if (permission.isRoute()) {
                //表示生成路由
                json.put("route", "1");
            } else {
                //表示不生成路由
                json.put("route", "0");
            }

            if (isWwwHttpUrl(permission.getUrl())) {
                json.put("path", Md5Util.md5Encode(permission.getUrl(), "utf-8"));
            } else {
                json.put("path", permission.getUrl());
            }

            // 重要规则：路由name (通过URL生成路由name,路由name供前端开发，页面跳转使用)
            if (oConvertUtils.isNotEmpty(permission.getComponentName())) {
                json.put("name", permission.getComponentName());
            } else {
                json.put("name", urlToRouteName(permission.getUrl()));
            }

            JSONObject meta = new JSONObject();
            // 是否隐藏路由，默认都是显示的
            if (permission.isHidden()) {
                json.put("hidden", true);
                //vue3版本兼容代码
                meta.put("hideMenu",true);
            }
            // 聚合路由
            if (permission.isAlwaysShow()) {
                json.put("alwaysShow", true);
            }
            json.put("component", permission.getComponent());
            // 由用户设置是否缓存页面 用布尔值
            if (permission.isKeepAlive()) {
                meta.put("keepAlive", true);
            } else {
                meta.put("keepAlive", false);
            }

            /*update_begin author:wuxianquan date:20190908 for:往菜单信息里添加外链菜单打开方式 */
            //外链菜单打开方式
            if (permission.isInternalOrExternal()) {
                meta.put("internalOrExternal", true);
            } else {
                meta.put("internalOrExternal", false);
            }
            /* update_end author:wuxianquan date:20190908 for: 往菜单信息里添加外链菜单打开方式*/

            meta.put("title", permission.getName());

            //update-begin--Author:scott  Date:20201015 for：路由缓存问题，关闭了tab页时再打开就不刷新 #842
            String component = permission.getComponent();
            if(oConvertUtils.isNotEmpty(permission.getComponentName()) || oConvertUtils.isNotEmpty(component)){
                meta.put("componentName", oConvertUtils.getString(permission.getComponentName(),component.substring(component.lastIndexOf("/")+1)));
            }
            //update-end--Author:scott  Date:20201015 for：路由缓存问题，关闭了tab页时再打开就不刷新 #842

            if (oConvertUtils.isEmpty(permission.getParentId())) {
                // 一级菜单跳转地址
                json.put("redirect", permission.getRedirect());
                if (oConvertUtils.isNotEmpty(permission.getIcon())) {
                    meta.put("icon", permission.getIcon());
                }
            } else {
                if (oConvertUtils.isNotEmpty(permission.getIcon())) {
                    meta.put("icon", permission.getIcon());
                }
            }
            if (isWwwHttpUrl(permission.getUrl())) {
                meta.put("url", permission.getUrl());
            }
            // update-begin--Author:sunjianlei  Date:20210918 for：新增适配vue3项目的隐藏tab功能
            if (permission.isHideTab()) {
                meta.put("hideTab", true);
            }
            // update-end--Author:sunjianlei  Date:20210918 for：新增适配vue3项目的隐藏tab功能
            json.put("meta", meta);
        }

        return json;
    }

    /**
     * 通过URL生成路由name（去掉URL前缀斜杠，替换内容中的斜杠‘/’为-） 举例： URL = /isystem/role RouteName =
     * isystem-role
     *
     * @return
     */
    private String urlToRouteName(String url) {
        if (oConvertUtils.isNotEmpty(url)) {
            if (url.startsWith(SymbolConstant.SINGLE_SLASH)) {
                url = url.substring(1);
            }
            url = url.replace("/", "-");

            // 特殊标记
            url = url.replace(":", "@");
            return url;
        } else {
            return null;
        }
    }

    /**
     * 判断是否外网URL 例如： http://localhost:8080/jeecg-boot/swagger-ui.html#/ 支持特殊格式： {{
     * window._CONFIG['domianURL'] }}/druid/ {{ JS代码片段 }}，前台解析会自动执行JS代码片段
     *
     * @return
     */
    private boolean isWwwHttpUrl(String url) {
        boolean flag = url != null && (url.startsWith(CommonConstant.HTTP_PROTOCOL) || url.startsWith(CommonConstant.HTTPS_PROTOCOL) || url.startsWith(SymbolConstant.DOUBLE_LEFT_CURLY_BRACKET));
        if (flag) {
            return true;
        }
        return false;
    }

    /**
     * 获取权限JSON数组
     */
    private void getAllAuthJsonArray(JSONArray jsonArray, List<SysPermissionEntity> allList) {
        JSONObject json = null;
        for (SysPermissionEntity permission : allList) {
            json = new JSONObject();
            json.put("action", permission.getPerms());
            json.put("status", permission.getStatus());
            //1显示2禁用
            json.put("type", permission.getPermsType());
            json.put("describe", permission.getName());
            jsonArray.add(json);
        }
    }

    /**
     *  获取权限JSON数组
     */
    private void getAuthJsonArray(JSONArray jsonArray,List<SysPermissionEntity> metaList) {
        for (SysPermissionEntity permission : metaList) {
            if(permission.getMenuType()==null) {
                continue;
            }
            JSONObject json = null;
            if(permission.getMenuType().equals(CommonConstant.MENU_TYPE_2) &&CommonConstant.STATUS_1.equals(permission.getStatus())) {
                json = new JSONObject();
                json.put("action", permission.getPerms());
                json.put("type", permission.getPermsType());
                json.put("describe", permission.getName());
                jsonArray.add(json);
            }
        }
    }
}
