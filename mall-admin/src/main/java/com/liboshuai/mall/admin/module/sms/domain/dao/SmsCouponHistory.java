package com.liboshuai.mall.admin.module.sms.domain.dao;

    import com.baomidou.mybatisplus.annotation.IdType;
    import com.baomidou.mybatisplus.annotation.TableField;
    import com.baomidou.mybatisplus.annotation.TableId;
    import com.baomidou.mybatisplus.annotation.TableName;
    import java.io.Serializable;
    import java.time.LocalDateTime;
    import io.swagger.annotations.ApiModel;
    import io.swagger.annotations.ApiModelProperty;
    import lombok.Data;

/**
* <p>
    * 优惠券使用、领取历史表
    * </p>
*
* @author liboshuai
* @since 2022-12-27
*/
    @Data
    @TableName("sms_coupon_history")
    @ApiModel(value = "SmsCouponHistory对象", description = "优惠券使用、领取历史表")
    public class SmsCouponHistory implements Serializable {

    private static final long serialVersionUID = 1L;

            @TableId(value = "id", type = IdType.AUTO)
    private Long id;

        @TableField("coupon_id")
    private Long couponId;

        @TableField("member_id")
    private Long memberId;

        @TableField("coupon_code")
    private String couponCode;

            @ApiModelProperty("领取人昵称")
        @TableField("member_nickname")
    private String memberNickname;

            @ApiModelProperty("获取类型：0->后台赠送；1->主动获取")
        @TableField("get_type")
    private Integer getType;

            @ApiModelProperty("创建时间")
        @TableField("create_time")
    private LocalDateTime createTime;

            @ApiModelProperty("使用状态：0->未使用；1->已使用；2->已过期")
        @TableField("use_status")
    private Integer useStatus;

            @ApiModelProperty("使用时间")
        @TableField("use_time")
    private LocalDateTime useTime;

            @ApiModelProperty("订单编号")
        @TableField("order_id")
    private Long orderId;

            @ApiModelProperty("订单号码")
        @TableField("order_sn")
    private String orderSn;

            @ApiModelProperty("创建用户")
        @TableField("create_user")
    private String createUser;

            @ApiModelProperty("更新用户")
        @TableField("update_user")
    private String updateUser;

            @ApiModelProperty("更新时间")
        @TableField("update_time")
    private LocalDateTime updateTime;

            @ApiModelProperty("逻辑删除: 0-未删除, 1-已删除")
        @TableField("is_delete")
    private String isDelete;


}




