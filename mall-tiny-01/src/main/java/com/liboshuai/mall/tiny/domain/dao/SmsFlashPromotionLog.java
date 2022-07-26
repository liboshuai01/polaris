package com.liboshuai.mall.tiny.domain.dao;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * <p>
 * 限时购通知记录
 * </p>
 *
 * @author liboshuai
 * @since 2022-07-26
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


}




