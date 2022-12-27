package com.liboshuai.mall.admin.module.oms.domain.dao;

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
    * 购物车表
    * </p>
*
* @author liboshuai
* @since 2022-12-27
*/
    @Data
    @TableName("oms_cart_item")
    @ApiModel(value = "OmsCartItem对象", description = "购物车表")
    public class OmsCartItem implements Serializable {

    private static final long serialVersionUID = 1L;

            @TableId(value = "id", type = IdType.AUTO)
    private Long id;

        @TableField("product_id")
    private Long productId;

        @TableField("product_sku_id")
    private Long productSkuId;

        @TableField("member_id")
    private Long memberId;

            @ApiModelProperty("购买数量")
        @TableField("quantity")
    private Integer quantity;

            @ApiModelProperty("添加到购物车的价格")
        @TableField("price")
    private BigDecimal price;

            @ApiModelProperty("商品主图")
        @TableField("product_pic")
    private String productPic;

            @ApiModelProperty("商品名称")
        @TableField("product_name")
    private String productName;

            @ApiModelProperty("商品副标题（卖点）")
        @TableField("product_sub_title")
    private String productSubTitle;

            @ApiModelProperty("商品sku条码")
        @TableField("product_sku_code")
    private String productSkuCode;

            @ApiModelProperty("会员昵称")
        @TableField("member_nickname")
    private String memberNickname;

            @ApiModelProperty("创建时间")
        @TableField("create_time")
    private LocalDateTime createTime;

            @ApiModelProperty("修改时间")
        @TableField("modify_date")
    private LocalDateTime modifyDate;

            @ApiModelProperty("逻辑删除: 0-未删除, 1-已删除")
        @TableField("is_delete")
    private String isDelete;

            @ApiModelProperty("商品分类")
        @TableField("product_category_id")
    private Long productCategoryId;

        @TableField("product_brand")
    private String productBrand;

        @TableField("product_sn")
    private String productSn;

            @ApiModelProperty("商品销售属性:[{\"key\":\"颜色\",\"value\":\"颜色\"},{\"key\":\"容量\",\"value\":\"4G\"}]")
        @TableField("product_attr")
    private String productAttr;

            @ApiModelProperty("创建用户")
        @TableField("create_user")
    private String createUser;

            @ApiModelProperty("更新用户")
        @TableField("update_user")
    private String updateUser;

            @ApiModelProperty("更新时间")
        @TableField("update_time")
    private LocalDateTime updateTime;


}




