package com.liboshuai.mall.tiny.domain.dao;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * <p>
 * 订单退货申请
 * </p>
 *
 * @author liboshuai
 * @since 2022-07-25
 */
@Data
@TableName("oms_order_return_apply")
@ApiModel(value = "OmsOrderReturnApply对象", description = "订单退货申请")
public class OmsOrderReturnApply implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    @ApiModelProperty("订单id")
    @TableField("order_id")
    private Long orderId;

    @ApiModelProperty("收货地址表id")
    @TableField("company_address_id")
    private Long companyAddressId;

    @ApiModelProperty("退货商品id")
    @TableField("product_id")
    private Long productId;

    @ApiModelProperty("订单编号")
    @TableField("order_sn")
    private String orderSn;

    @ApiModelProperty("申请时间")
    @TableField("create_time")
    private LocalDateTime createTime;

    @ApiModelProperty("会员用户名")
    @TableField("member_username")
    private String memberUsername;

    @ApiModelProperty("退款金额")
    @TableField("return_amount")
    private BigDecimal returnAmount;

    @ApiModelProperty("退货人姓名")
    @TableField("return_name")
    private String returnName;

    @ApiModelProperty("退货人电话")
    @TableField("return_phone")
    private String returnPhone;

    @ApiModelProperty("申请状态：0->待处理；1->退货中；2->已完成；3->已拒绝")
    @TableField("status")
    private Integer status;

    @ApiModelProperty("处理时间")
    @TableField("handle_time")
    private LocalDateTime handleTime;

    @ApiModelProperty("商品图片")
    @TableField("product_pic")
    private String productPic;

    @ApiModelProperty("商品名称")
    @TableField("product_name")
    private String productName;

    @ApiModelProperty("商品品牌")
    @TableField("product_brand")
    private String productBrand;

    @ApiModelProperty("商品销售属性：颜色：红色；尺码：xl;")
    @TableField("product_attr")
    private String productAttr;

    @ApiModelProperty("退货数量")
    @TableField("product_count")
    private Integer productCount;

    @ApiModelProperty("商品单价")
    @TableField("product_price")
    private BigDecimal productPrice;

    @ApiModelProperty("商品实际支付单价")
    @TableField("product_real_price")
    private BigDecimal productRealPrice;

    @ApiModelProperty("原因")
    @TableField("reason")
    private String reason;

    @ApiModelProperty("描述")
    @TableField("description")
    private String description;

    @ApiModelProperty("凭证图片，以逗号隔开")
    @TableField("proof_pics")
    private String proofPics;

    @ApiModelProperty("处理备注")
    @TableField("handle_note")
    private String handleNote;

    @ApiModelProperty("处理人员")
    @TableField("handle_man")
    private String handleMan;

    @ApiModelProperty("收货人")
    @TableField("receive_man")
    private String receiveMan;

    @ApiModelProperty("收货时间")
    @TableField("receive_time")
    private LocalDateTime receiveTime;

    @ApiModelProperty("收货备注")
    @TableField("receive_note")
    private String receiveNote;


}




