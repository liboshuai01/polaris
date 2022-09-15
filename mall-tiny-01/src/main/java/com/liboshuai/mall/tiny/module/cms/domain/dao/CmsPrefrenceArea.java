package com.liboshuai.mall.tiny.module.cms.domain.dao;

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
    * 优选专区
    * </p>
*
* @author liboshuai
* @since 2022-09-16
*/
    @Data
    @TableName("cms_prefrence_area")
    @ApiModel(value = "CmsPrefrenceArea对象", description = "优选专区")
    public class CmsPrefrenceArea implements Serializable {

    private static final long serialVersionUID = 1L;

            @TableId(value = "id", type = IdType.AUTO)
    private Long id;

        @TableField("name")
    private String name;

        @TableField("sub_title")
    private String subTitle;

            @ApiModelProperty("展示图片")
        @TableField("pic")
    private byte[] pic;

        @TableField("sort")
    private Integer sort;

        @TableField("show_status")
    private Integer showStatus;

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




