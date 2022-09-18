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
import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * <p>
 * 会员等级表
 * </p>
 *
 * @author liboshuai
 * @since 2022-09-16
 */
@Data
@TableName("ums_member_level")
@ApiModel(value = "UmsMemberLevel对象", description = "会员等级表")
public class UmsMemberLevel extends BaseEntity {

    private static final long serialVersionUID = 1L;

    @TableField("name")
    private String name;

    @TableField("growth_point")
    private Integer growthPoint;

    @ApiModelProperty("是否为默认等级：0->不是；1->是")
    @TableField("default_status")
    private Integer defaultStatus;

    @ApiModelProperty("免运费标准")
    @TableField("free_freight_point")
    private BigDecimal freeFreightPoint;

    @ApiModelProperty("每次评价获取的成长值")
    @TableField("comment_growth_point")
    private Integer commentGrowthPoint;

    @ApiModelProperty("是否有免邮特权")
    @TableField("priviledge_free_freight")
    private Integer priviledgeFreeFreight;

    @ApiModelProperty("是否有签到特权")
    @TableField("priviledge_sign_in")
    private Integer priviledgeSignIn;

    @ApiModelProperty("是否有评论获奖励特权")
    @TableField("priviledge_comment")
    private Integer priviledgeComment;

    @ApiModelProperty("是否有专享活动特权")
    @TableField("priviledge_promotion")
    private Integer priviledgePromotion;

    @ApiModelProperty("是否有会员价格特权")
    @TableField("priviledge_member_price")
    private Integer priviledgeMemberPrice;

    @ApiModelProperty("是否有生日特权")
    @TableField("priviledge_birthday")
    private Integer priviledgeBirthday;

}




