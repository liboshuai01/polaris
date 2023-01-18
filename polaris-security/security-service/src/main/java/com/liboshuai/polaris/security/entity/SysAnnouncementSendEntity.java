package com.liboshuai.polaris.security.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.liboshuai.polaris.common.domain.BaseEntity;
import lombok.*;

/**
 * @Author: liboshuai
 * @Date: 2023-01-18 11:12
 * @Description:
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@TableName("sys_announcement_send")
public class SysAnnouncementSendEntity extends BaseEntity {
    private static final long serialVersionUID = 1L;

    /**
     * 通告id
     */
    private java.lang.String anntId;
    /**
     * 用户id
     */
    private java.lang.String userId;
    /**
     * 阅读状态（0未读，1已读）
     */
    private java.lang.String readFlag;
    /**
     * 阅读时间
     */
    private java.util.Date readTime;
    /**
     * 是否标星 当值为1是标星消息
     */
    private String starFlag;
}
