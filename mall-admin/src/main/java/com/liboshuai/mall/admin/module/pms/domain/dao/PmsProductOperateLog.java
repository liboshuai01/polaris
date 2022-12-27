package com.liboshuai.mall.admin.module.pms.domain.dao;

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
    * 
    * </p>
*
* @author liboshuai
* @since 2022-12-27
*/
    @Data
    @TableName("pms_product_operate_log")
    @ApiModel(value = "PmsProductOperateLog对象", description = "")
    public class PmsProductOperateLog implements Serializable {

    private static final long serialVersionUID = 1L;

            @TableId(value = "id", type = IdType.AUTO)
    private Long id;

        @TableField("product_id")
    private Long productId;

        @TableField("price_old")
    private BigDecimal priceOld;

        @TableField("price_new")
    private BigDecimal priceNew;

        @TableField("sale_price_old")
    private BigDecimal salePriceOld;

        @TableField("sale_price_new")
    private BigDecimal salePriceNew;

            @ApiModelProperty("赠送的积分")
        @TableField("gift_point_old")
    private Integer giftPointOld;

        @TableField("gift_point_new")
    private Integer giftPointNew;

        @TableField("use_point_limit_old")
    private Integer usePointLimitOld;

        @TableField("use_point_limit_new")
    private Integer usePointLimitNew;

            @ApiModelProperty("操作人")
        @TableField("operate_man")
    private String operateMan;

            @ApiModelProperty("创建时间")
        @TableField("create_time")
    private LocalDateTime createTime;

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




