package com.liboshuai.mall.admin.module.pms.domain.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.liboshuai.mall.admin.common.base.BaseEntity;
import io.swagger.annotations.ApiModel;
import lombok.Data;

/**
 * <p>
 * 画册图片表
 * </p>
 *
 * @author liboshuai
 * @since 2022-09-16
 */
@Data
@TableName("pms_album_pic")
@ApiModel(value = "PmsAlbumPic对象", description = "画册图片表")
public class PmsAlbumPic extends BaseEntity {

    private static final long serialVersionUID = 1L;

    @TableField("album_id")
    private Long albumId;

    @TableField("pic")
    private String pic;

}




