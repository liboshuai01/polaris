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
    * sku的库存
    * </p>
*
* @author liboshuai
* @since 2022-12-27
*/
    @Data
    @TableName("pms_sku_stock")
    @ApiModel(value = "PmsSkuStock对象", description = "sku的库存")
    public class PmsSkuStock implements Serializable {

    private static final long serialVersionUID = 1L;

            @TableId(value = "id", type = IdType.AUTO)
    private Long id;

        @TableField("product_id")
    private Long productId;

            @ApiModelProperty("sku编码")
        @TableField("sku_code")
    private String skuCode;

        @TableField("price")
    private BigDecimal price;

            @ApiModelProperty("库存")
        @TableField("stock")
    private Integer stock;

            @ApiModelProperty("预警库存")
        @TableField("low_stock")
    private Integer lowStock;

            @ApiModelProperty("展示图片")
        @TableField("pic")
    private String pic;

            @ApiModelProperty("销量")
        @TableField("sale")
    private Integer sale;

            @ApiModelProperty("单品促销价格")
        @TableField("promotion_price")
    private BigDecimal promotionPrice;

            @ApiModelProperty("锁定库存")
        @TableField("lock_stock")
    private Integer lockStock;

            @ApiModelProperty("商品销售属性，json格式")
        @TableField("sp_data")
    private String spData;

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




