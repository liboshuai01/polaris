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
    * 商品会员价格表
    * </p>
*
* @author liboshuai
* @since 2022-12-27
*/
    @Data
    @TableName("pms_member_price")
    @ApiModel(value = "PmsMemberPrice对象", description = "商品会员价格表")
    public class PmsMemberPrice implements Serializable {

    private static final long serialVersionUID = 1L;

            @TableId(value = "id", type = IdType.AUTO)
    private Long id;

        @TableField("product_id")
    private Long productId;

        @TableField("member_level_id")
    private Long memberLevelId;

            @ApiModelProperty("会员价格")
        @TableField("member_price")
    private BigDecimal memberPrice;

        @TableField("member_level_name")
    private String memberLevelName;

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




