package com.liboshuai.mall.tiny.module.ums.domain.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.liboshuai.mall.tiny.common.base.BaseEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * <p>
 * 会员收货地址表
 * </p>
 *
 * @author liboshuai
 * @since 2022-09-16
 */
@Data
@TableName("ums_member_receive_address")
@ApiModel(value = "UmsMemberReceiveAddress对象", description = "会员收货地址表")
public class UmsMemberReceiveAddress extends BaseEntity {

    private static final long serialVersionUID = 1L;

    @TableField("member_id")
    private Long memberId;

    @ApiModelProperty("收货人名称")
    @TableField("name")
    private String name;

    @TableField("phone_number")
    private String phoneNumber;

    @ApiModelProperty("是否为默认")
    @TableField("default_status")
    private Integer defaultStatus;

    @ApiModelProperty("邮政编码")
    @TableField("post_code")
    private String postCode;

    @ApiModelProperty("省份/直辖市")
    @TableField("province")
    private String province;

    @ApiModelProperty("城市")
    @TableField("city")
    private String city;

    @ApiModelProperty("区")
    @TableField("region")
    private String region;

    @ApiModelProperty("详细地址(街道)")
    @TableField("detail_address")
    private String detailAddress;

}




