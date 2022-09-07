package com.liboshuai.mall.tiny.module.sms.domain.dao;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import lombok.Data;

import java.io.Serializable;

/**
 * <p>
 * 首页推荐品牌表
 * </p>
 *
 * @author liboshuai
 * @since 2022-07-26
 */
@Data
@TableName("sms_home_brand")
@ApiModel(value = "SmsHomeBrand对象", description = "首页推荐品牌表")
public class SmsHomeBrand implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    @TableField("brand_id")
    private Long brandId;

    @TableField("brand_name")
    private String brandName;

        @TableField("recommend_status")
        private Integer recommendStatus;

        @TableField("sort")
        private Integer sort;


}




