package com.liboshuai.mall.admin.module.oms.domain.dao;

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
    * 订单设置表
    * </p>
*
* @author liboshuai
* @since 2022-12-27
*/
    @Data
    @TableName("oms_order_setting")
    @ApiModel(value = "OmsOrderSetting对象", description = "订单设置表")
    public class OmsOrderSetting implements Serializable {

    private static final long serialVersionUID = 1L;

            @TableId(value = "id", type = IdType.AUTO)
    private Long id;

            @ApiModelProperty("秒杀订单超时关闭时间(分)")
        @TableField("flash_order_overtime")
    private Integer flashOrderOvertime;

            @ApiModelProperty("正常订单超时时间(分)")
        @TableField("normal_order_overtime")
    private Integer normalOrderOvertime;

            @ApiModelProperty("发货后自动确认收货时间（天）")
        @TableField("confirm_overtime")
    private Integer confirmOvertime;

            @ApiModelProperty("自动完成交易时间，不能申请售后（天）")
        @TableField("finish_overtime")
    private Integer finishOvertime;

            @ApiModelProperty("订单完成后自动好评时间（天）")
        @TableField("comment_overtime")
    private Integer commentOvertime;

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




