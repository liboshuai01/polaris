package com.liboshuai.polaris.security.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.liboshuai.polaris.common.domain.BaseEntity;
import lombok.*;

/**
 * @Author: liboshuai
 * @Date: 2023-01-18 11:03
 * @Description:
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@TableName("sys_announcement")
public class SysAnnouncementEntity extends BaseEntity {
    private static final long serialVersionUID = 1L;

    /**
     * 标题
     */
    private java.lang.String titile;
    /**
     * 内容
     */
    private java.lang.String msgContent;
    /**
     * 开始时间
     */
    private java.util.Date startTime;
    /**
     * 结束时间
     */
    private java.util.Date endTime;
    /**
     * 发布人
     */
    private java.lang.String sender;
    /**
     * 优先级（L低，M中，H高）
     */
    private java.lang.String priority;

    /**
     * 消息类型1:通知公告2:系统消息
     */
    private java.lang.String msgCategory;
    /**
     * 通告对象类型（USER:指定用户，ALL:全体用户）
     */
    private java.lang.String msgType;
    /**
     * 发布状态（0未发布，1已发布，2已撤销）
     */
    private java.lang.String sendStatus;
    /**
     * 发布时间
     */
    private java.util.Date sendTime;
    /**
     * 撤销时间
     */
    private java.util.Date cancelTime;
    /**
     * 指定用户
     **/
    private java.lang.String userIds;
    /**
     * 业务类型(email:邮件 bpm:流程)
     */
    private java.lang.String busType;
    /**
     * 业务id
     */
    private java.lang.String busId;
    /**
     * 打开方式 组件：component 路由：url
     */
    private java.lang.String openType;
    /**
     * 组件/路由 地址
     */
    private java.lang.String openPage;
    /**
     * 摘要
     */
    private java.lang.String msgAbstract;
    /**
     * 钉钉task_id，用于撤回消息
     */
    private String dtTaskId;

    /**
     * 阅读状态 1表示已经阅读
     */
    private transient String readFlag;

    /**
     * 标星状态 1表示标星
     */
    private transient String starFlag;

    /**
     * 发送记录ID
     */
    private transient String sendId;
}
