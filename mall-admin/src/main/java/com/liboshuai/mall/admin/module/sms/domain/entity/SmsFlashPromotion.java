package com.liboshuai.mall.admin.module.sms.domain.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.liboshuai.mall.admin.common.base.BaseEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.time.LocalDate;

/**
 * <p>
 * 限时购表
 * </p>
 *
 * @author liboshuai
 * @since 2022-09-16
 */
@Data
@TableName("sms_flash_promotion")
@ApiModel(value = "SmsFlashPromotion对象", description = "限时购表")
public class SmsFlashPromotion extends BaseEntity {

    private static final long serialVersionUID = 1L;

    @TableField("title")
    private String title;

    @ApiModelProperty("开始日期")
    @TableField("start_date")
    private LocalDate startDate;

    @ApiModelProperty("结束日期")
    @TableField("end_date")
    private LocalDate endDate;

    @ApiModelProperty("上下线状态")
    @TableField("status")
    private Integer status;

}




