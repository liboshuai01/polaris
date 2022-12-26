package com.liboshuai.mall.admin.module.sms.domain.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.liboshuai.mall.admin.common.base.BaseEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * <p>
 * 首页轮播广告表
 * </p>
 *
 * @author liboshuai
 * @since 2022-09-16
 */
@Data
@TableName("sms_home_advertise")
@ApiModel(value = "SmsHomeAdvertise对象", description = "首页轮播广告表")
public class SmsHomeAdvertise extends BaseEntity {

    private static final long serialVersionUID = 1L;

    @TableField("name")
    private String name;

    @ApiModelProperty("轮播位置：0->PC首页轮播；1->app首页轮播")
    @TableField("type")
    private Integer type;

    @TableField("pic")
    private String pic;

    @TableField("start_time")
    private LocalDateTime startTime;

    @TableField("end_time")
    private LocalDateTime endTime;

    @ApiModelProperty("上下线状态：0->下线；1->上线")
    @TableField("status")
    private Integer status;

    @ApiModelProperty("点击数")
    @TableField("click_count")
    private Integer clickCount;

    @ApiModelProperty("下单数")
    @TableField("order_count")
    private Integer orderCount;

    @ApiModelProperty("链接地址")
    @TableField("url")
    private String url;

    @ApiModelProperty("备注")
    @TableField("note")
    private String note;

    @ApiModelProperty("排序")
    @TableField("sort")
    private Integer sort;

}




