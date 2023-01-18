package com.liboshuai.polaris.security.mapper;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.liboshuai.polaris.common.domain.RootMapper;
import com.liboshuai.polaris.security.entity.SysAnnouncementEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;

/**
 * @Author: liboshuai
 * @Date: 2023-01-18 11:09
 * @Description:
 */
@Mapper
public interface SysAnnouncementMapper extends RootMapper<SysAnnouncementEntity> {

    /**
     * 通过消息类型和用户id获取系统通告
     * @param userId 用户id
     * @param msgCategory 消息类型
     * @return
     */
    List<SysAnnouncementEntity> querySysCementListByUserId(Page<SysAnnouncementEntity> page, @Param("userId")String userId, @Param("msgCategory")String msgCategory);

    /**
     * 分页查询消息列表

     */
    List<SysAnnouncementEntity> queryMessageList(Page<SysAnnouncementEntity> page, @Param("userId")String userId, @Param("fromUser")String fromUser, @Param("starFlag")String starFlag, @Param("beginDate") Date beginDate, @Param("endDate")Date endDate);
}
