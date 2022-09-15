package com.liboshuai.mall.tiny.module.oms.domain.dao;

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
    * 订单操作历史记录
    * </p>
*
* @author liboshuai
* @since 2022-09-16
*/
    @Data
    @TableName("oms_order_operate_history")
    @ApiModel(value = "OmsOrderOperateHistory对象", description = "订单操作历史记录")
    public class OmsOrderOperateHistory implements Serializable {

    private static final long serialVersionUID = 1L;

            @TableId(value = "id", type = IdType.AUTO)
    private Long id;

            @ApiModelProperty("订单id")
        @TableField("order_id")
    private Long orderId;

            @ApiModelProperty("操作人：用户；系统；后台管理员")
        @TableField("operate_man")
    private String operateMan;

            @ApiModelProperty("订单状态：0->待付款；1->待发货；2->已发货；3->已完成；4->已关闭；5->无效订单")
        @TableField("order_status")
    private Integer orderStatus;

            @ApiModelProperty("备注")
        @TableField("note")
    private String note;

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

            @ApiModelProperty("是否被逻辑删除 0-未被删除 1-已被删除")
        @TableField("is_delete")
    private String isDelete;


}




