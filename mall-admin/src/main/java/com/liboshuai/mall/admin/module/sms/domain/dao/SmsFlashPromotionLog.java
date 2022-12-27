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
    * 限时购通知记录
    * </p>
*
* @author liboshuai
* @since 2022-12-27
*/
    @Data
    @TableName("sms_flash_promotion_log")
    @ApiModel(value = "SmsFlashPromotionLog对象", description = "限时购通知记录")
    public class SmsFlashPromotionLog implements Serializable {

    private static final long serialVersionUID = 1L;

            @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

        @TableField("member_id")
    private Integer memberId;

        @TableField("product_id")
    private Long productId;

        @TableField("member_phone")
    private String memberPhone;

        @TableField("product_name")
    private String productName;

            @ApiModelProperty("会员订阅时间")
        @TableField("subscribe_time")
    private LocalDateTime subscribeTime;

        @TableField("send_time")
    private LocalDateTime sendTime;

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




