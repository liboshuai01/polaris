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
    * 会员统计信息
    * </p>
*
* @author liboshuai
* @since 2022-09-16
*/
    @Data
    @TableName("ums_member_statistics_info")
    @ApiModel(value = "UmsMemberStatisticsInfo对象", description = "会员统计信息")
    public class UmsMemberStatisticsInfo implements Serializable {

    private static final long serialVersionUID = 1L;

            @TableId(value = "id", type = IdType.AUTO)
    private Long id;

        @TableField("member_id")
    private Long memberId;

            @ApiModelProperty("累计消费金额")
        @TableField("consume_amount")
    private BigDecimal consumeAmount;

            @ApiModelProperty("订单数量")
        @TableField("order_count")
    private Integer orderCount;

            @ApiModelProperty("优惠券数量")
        @TableField("coupon_count")
    private Integer couponCount;

            @ApiModelProperty("评价数")
        @TableField("comment_count")
    private Integer commentCount;

            @ApiModelProperty("退货数量")
        @TableField("return_order_count")
    private Integer returnOrderCount;

            @ApiModelProperty("登录次数")
        @TableField("login_count")
    private Integer loginCount;

            @ApiModelProperty("关注数量")
        @TableField("attend_count")
    private Integer attendCount;

            @ApiModelProperty("粉丝数量")
        @TableField("fans_count")
    private Integer fansCount;

        @TableField("collect_product_count")
    private Integer collectProductCount;

        @TableField("collect_subject_count")
    private Integer collectSubjectCount;

        @TableField("collect_topic_count")
    private Integer collectTopicCount;

        @TableField("collect_comment_count")
    private Integer collectCommentCount;

        @TableField("invite_friend_count")
    private Integer inviteFriendCount;

            @ApiModelProperty("最后一次下订单时间")
        @TableField("recent_order_time")
    private LocalDateTime recentOrderTime;

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




