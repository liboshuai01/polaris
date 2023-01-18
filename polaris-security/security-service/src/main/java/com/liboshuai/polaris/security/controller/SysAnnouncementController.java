package com.liboshuai.polaris.security.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.liboshuai.polaris.common.constants.CommonConstant;
import com.liboshuai.polaris.common.domain.ResponseResult;
import com.liboshuai.polaris.security.dto.SysUserDTO;
import com.liboshuai.polaris.security.entity.SysAnnouncementEntity;
import com.liboshuai.polaris.security.entity.SysAnnouncementSendEntity;
import com.liboshuai.polaris.security.service.SysAnnouncementSendService;
import com.liboshuai.polaris.security.service.SysAnnouncementService;
import com.liboshuai.polaris.security.service.SysUserService;
import io.swagger.annotations.Api;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

/**
 * @Author: liboshuai
 * @Date: 2023-01-18 11:00
 * @Description: 系统通告表
 */
@Slf4j
@RestController
@NoArgsConstructor
@RequestMapping("/announcement")
@Api(tags = "系统通告表", value = "SysAnnouncementController")
public class SysAnnouncementController {

    private SysUserService sysUserService;
    private SysAnnouncementService sysAnnouncementService;
    private SysAnnouncementSendService sysAnnouncementSendService;

    @Autowired
    public SysAnnouncementController(SysUserService sysUserService, SysAnnouncementService sysAnnouncementService,
                                     SysAnnouncementSendService sysAnnouncementSendService) {
        this.sysUserService = sysUserService;
        this.sysAnnouncementService = sysAnnouncementService;
        this.sysAnnouncementSendService = sysAnnouncementSendService;
    }

    /**
     * @功能：补充用户数据，并返回系统消息
     */
    @RequestMapping(value = "/listByUser", method = RequestMethod.GET)
    public ResponseResult<Map<String, Object>> listByUser(@RequestParam(required = false, defaultValue = "5") Integer pageSize) {
        // todo: 获取当前系统登录用户, 临时使用admin代替
        ResponseResult<SysUserDTO> userDTOResponseResult = sysUserService.findUserByName("admin");
        if (Objects.isNull(userDTOResponseResult) || !userDTOResponseResult.isSuccess()) {
            return ResponseResult.fail("查询用户信息失败");
        }
        SysUserDTO sysUserDTO = userDTOResponseResult.getResult();
        String userId = sysUserDTO.getId();
        // 1.将系统消息补充到用户通告阅读标记表中
        LambdaQueryWrapper<SysAnnouncementEntity> querySaWrapper = new LambdaQueryWrapper<>();
        //全部人员
        querySaWrapper.eq(SysAnnouncementEntity::getMsgType, CommonConstant.MSG_TYPE_ALL);
        //未删除
        querySaWrapper.eq(SysAnnouncementEntity::getIsDelete, CommonConstant.DEL_FLAG_0.toString());
        //已发布
        querySaWrapper.eq(SysAnnouncementEntity::getSendStatus, CommonConstant.HAS_SEND);
        //新注册用户不看结束通知
        querySaWrapper.ge(SysAnnouncementEntity::getEndTime, sysUserDTO.getCreateTime());
        //update-begin--Author:liusq  Date:20210108 for：[JT-424] 【开源issue】bug处理--------------------
        querySaWrapper.notInSql(SysAnnouncementEntity::getId, "select annt_id from sys_announcement_send where user_id='" + userId + "'");
        //update-begin--Author:liusq  Date:20210108  for： [JT-424] 【开源issue】bug处理--------------------
        List<SysAnnouncementEntity> announcements = sysAnnouncementService.list(querySaWrapper);
        if (announcements.size() > 0) {
            for (int i = 0; i < announcements.size(); i++) {
                //update-begin--Author:wangshuai  Date:20200803  for： 通知公告消息重复LOWCOD-759--------------------
                //因为websocket没有判断是否存在这个用户，要是判断会出现问题，故在此判断逻辑
                LambdaQueryWrapper<SysAnnouncementSendEntity> query = new LambdaQueryWrapper<>();
                query.eq(SysAnnouncementSendEntity::getAnntId, announcements.get(i).getId());
                query.eq(SysAnnouncementSendEntity::getUserId, userId);
                SysAnnouncementSendEntity one = sysAnnouncementSendService.getOne(query);
                if (null == one) {
                    log.info("listByUser接口新增了SysAnnouncementSend：pageSize{}：" + pageSize);
                    SysAnnouncementSendEntity announcementSend = new SysAnnouncementSendEntity();
                    announcementSend.setAnntId(announcements.get(i).getId());
                    announcementSend.setUserId(userId);
                    announcementSend.setReadFlag(CommonConstant.NO_READ_FLAG);
                    sysAnnouncementSendService.save(announcementSend);
                    log.info("announcementSend.toString()", announcementSend.toString());
                }
                //update-end--Author:wangshuai  Date:20200803  for： 通知公告消息重复LOWCOD-759------------
            }
        }
        // 2.查询用户未读的系统消息
        Page<SysAnnouncementEntity> anntMsgList = new Page<>(0, pageSize);
        //通知公告消息
        anntMsgList = sysAnnouncementService.querySysCementPageByUserId(anntMsgList, userId, "1");
        Page<SysAnnouncementEntity> sysMsgList = new Page<>(0, pageSize);
        //系统消息
        sysMsgList = sysAnnouncementService.querySysCementPageByUserId(sysMsgList, userId, "2");
        Map<String, Object> sysMsgMap = new HashMap(5);
        sysMsgMap.put("sysMsgList", sysMsgList.getRecords());
        sysMsgMap.put("sysMsgTotal", sysMsgList.getTotal());
        sysMsgMap.put("anntMsgList", anntMsgList.getRecords());
        sysMsgMap.put("anntMsgTotal", anntMsgList.getTotal());
        return ResponseResult.success(sysMsgMap);
    }
}
