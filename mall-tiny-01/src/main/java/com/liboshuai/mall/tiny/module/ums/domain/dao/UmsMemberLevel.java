package com.liboshuai.mall.tiny.module.ums.domain.dao;

    import com.baomidou.mybatisplus.annotation.IdType;
    import com.baomidou.mybatisplus.annotation.TableField;
    import com.baomidou.mybatisplus.annotation.TableId;
    import com.baomidou.mybatisplus.annotation.TableName;
    import java.io.Serializable;
    import java.math.BigDecimal;
    import java.time.LocalDateTime;
    import io.swagger.annotations.ApiModel;
    import io.swagger.annotations.ApiModelProperty;
    import lombok.Data;

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
    public class UmsMemberLevel implements Serializable {

    private static final long serialVersionUID = 1L;

            @TableId(value = "id", type = IdType.AUTO)
    private Long id;

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

        @TableField("note")
    private String note;


}




