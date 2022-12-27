package com.liboshuai.mall.admin.module.cms.domain.dao;

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
    * 优选专区和产品关系表
    * </p>
*
* @author liboshuai
* @since 2022-12-27
*/
    @Data
    @TableName("cms_prefrence_area_product_relation")
    @ApiModel(value = "CmsPrefrenceAreaProductRelation对象", description = "优选专区和产品关系表")
    public class CmsPrefrenceAreaProductRelation implements Serializable {

    private static final long serialVersionUID = 1L;

            @TableId(value = "id", type = IdType.AUTO)
    private Long id;

        @TableField("prefrence_area_id")
    private Long prefrenceAreaId;

        @TableField("product_id")
    private Long productId;

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




