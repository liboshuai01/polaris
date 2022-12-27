package com.liboshuai.mall.admin.module.ums.domain.dao;

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
    * 积分消费设置
    * </p>
*
* @author liboshuai
* @since 2022-12-27
*/
    @Data
    @TableName("ums_integration_consume_setting")
    @ApiModel(value = "UmsIntegrationConsumeSetting对象", description = "积分消费设置")
    public class UmsIntegrationConsumeSetting implements Serializable {

    private static final long serialVersionUID = 1L;

            @TableId(value = "id", type = IdType.AUTO)
    private Long id;

            @ApiModelProperty("每一元需要抵扣的积分数量")
        @TableField("deduction_per_amount")
    private Integer deductionPerAmount;

            @ApiModelProperty("每笔订单最高抵用百分比")
        @TableField("max_percent_per_order")
    private Integer maxPercentPerOrder;

            @ApiModelProperty("每次使用积分最小单位100")
        @TableField("use_unit")
    private Integer useUnit;

            @ApiModelProperty("是否可以和优惠券同用；0->不可以；1->可以")
        @TableField("coupon_status")
    private Integer couponStatus;

            @ApiModelProperty("创建用户")
        @TableField("create_user")
    private String createUser;

            @ApiModelProperty("创建时间")
        @TableField("create_time")
    private LocalDateTime createTime;

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




