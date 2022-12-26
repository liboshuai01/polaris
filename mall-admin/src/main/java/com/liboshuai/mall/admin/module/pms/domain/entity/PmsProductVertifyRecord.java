package com.liboshuai.mall.admin.module.pms.domain.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.liboshuai.mall.admin.common.base.BaseEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * <p>
 * 商品审核记录
 * </p>
 *
 * @author liboshuai
 * @since 2022-09-16
 */
@Data
@TableName("pms_product_vertify_record")
@ApiModel(value = "PmsProductVertifyRecord对象", description = "商品审核记录")
public class PmsProductVertifyRecord extends BaseEntity {

    private static final long serialVersionUID = 1L;

    @TableField("product_id")
    private Long productId;

    @ApiModelProperty("审核人")
    @TableField("vertify_man")
    private String vertifyMan;

    @TableField("status")
    private Integer status;

    @ApiModelProperty("反馈详情")
    @TableField("detail")
    private String detail;

}




