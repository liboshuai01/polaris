package com.liboshuai.mall.admin.module.cms.domain.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.liboshuai.mall.admin.common.base.BaseEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

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
public class CmsPrefrenceArea extends BaseEntity {

    private static final long serialVersionUID = 1L;

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


}




