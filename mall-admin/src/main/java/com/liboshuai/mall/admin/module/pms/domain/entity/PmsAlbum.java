package com.liboshuai.mall.admin.module.pms.domain.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.liboshuai.mall.admin.common.base.BaseEntity;
import io.swagger.annotations.ApiModel;
import lombok.Data;

/**
 * <p>
 * 相册表
 * </p>
 *
 * @author liboshuai
 * @since 2022-09-16
 */
@Data
@TableName("pms_album")
@ApiModel(value = "PmsAlbum对象", description = "相册表")
public class PmsAlbum extends BaseEntity {

    private static final long serialVersionUID = 1L;

    @TableField("name")
    private String name;

    @TableField("cover_pic")
    private String coverPic;

    @TableField("pic_count")
    private Integer picCount;

    @TableField("sort")
    private Integer sort;

    @TableField("description")
    private String description;


}




