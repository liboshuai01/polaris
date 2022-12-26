package com.liboshuai.mall.admin.module.sms.domain.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.liboshuai.mall.admin.common.base.BaseEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.time.LocalTime;

/**
 * <p>
 * 限时购场次表
 * </p>
 *
 * @author liboshuai
 * @since 2022-09-16
 */
@Data
@TableName("sms_flash_promotion_session")
@ApiModel(value = "SmsFlashPromotionSession对象", description = "限时购场次表")
public class SmsFlashPromotionSession extends BaseEntity {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("场次名称")
    @TableField("name")
    private String name;

    @ApiModelProperty("每日开始时间")
    @TableField("start_time")
    private LocalTime startTime;

    @ApiModelProperty("每日结束时间")
    @TableField("end_time")
    private LocalTime endTime;

    @ApiModelProperty("启用状态：0->不启用；1->启用")
    @TableField("status")
    private Integer status;

}




