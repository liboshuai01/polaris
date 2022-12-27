package com.liboshuai.mall.admin.module.pms.domain.dao;

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
    * 产品分类
    * </p>
*
* @author liboshuai
* @since 2022-12-27
*/
    @Data
    @TableName("pms_product_category")
    @ApiModel(value = "PmsProductCategory对象", description = "产品分类")
    public class PmsProductCategory implements Serializable {

    private static final long serialVersionUID = 1L;

            @TableId(value = "id", type = IdType.AUTO)
    private Long id;

            @ApiModelProperty("上机分类的编号：0表示一级分类")
        @TableField("parent_id")
    private Long parentId;

        @TableField("name")
    private String name;

            @ApiModelProperty("分类级别：0->1级；1->2级")
        @TableField("level")
    private Integer level;

        @TableField("product_count")
    private Integer productCount;

        @TableField("product_unit")
    private String productUnit;

            @ApiModelProperty("是否显示在导航栏：0->不显示；1->显示")
        @TableField("nav_status")
    private Integer navStatus;

            @ApiModelProperty("显示状态：0->不显示；1->显示")
        @TableField("show_status")
    private Integer showStatus;

        @TableField("sort")
    private Integer sort;

            @ApiModelProperty("图标")
        @TableField("icon")
    private String icon;

        @TableField("keywords")
    private String keywords;

            @ApiModelProperty("描述")
        @TableField("description")
    private String description;

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




