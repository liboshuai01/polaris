package com.liboshuai.mall.admin.module.oms.domain.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.liboshuai.mall.admin.common.base.BaseEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * <p>
 * 公司收发货地址表
 * </p>
 *
 * @author liboshuai
 * @since 2022-09-16
 */
@Data
@TableName("oms_company_address")
@ApiModel(value = "OmsCompanyAddress对象", description = "公司收发货地址表")
public class OmsCompanyAddress extends BaseEntity {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("地址名称")
    @TableField("address_name")
    private String addressName;

    @ApiModelProperty("默认发货地址：0->否；1->是")
    @TableField("send_status")
    private Integer sendStatus;

    @ApiModelProperty("是否默认收货地址：0->否；1->是")
    @TableField("receive_status")
    private Integer receiveStatus;

    @ApiModelProperty("收发货人姓名")
    @TableField("name")
    private String name;

    @ApiModelProperty("收货人电话")
    @TableField("phone")
    private String phone;

    @ApiModelProperty("省/直辖市")
    @TableField("province")
    private String province;

    @ApiModelProperty("市")
    @TableField("city")
    private String city;

    @ApiModelProperty("区")
    @TableField("region")
    private String region;

    @ApiModelProperty("详细地址")
    @TableField("detail_address")
    private String detailAddress;


}




