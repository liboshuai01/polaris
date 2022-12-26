package com.liboshuai.mall.admin.module.cms.domain.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.liboshuai.mall.admin.common.base.BaseEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * <p>
 * 用户举报表
 * </p>
 *
 * @author liboshuai
 * @since 2022-09-16
 */
@Data
@TableName("cms_member_report")
@ApiModel(value = "CmsMemberReport对象", description = "用户举报表")
public class CmsMemberReport extends BaseEntity {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("举报类型：0->商品评价；1->话题内容；2->用户评论")
    @TableField("report_type")
    private Integer reportType;

    @ApiModelProperty("举报人")
    @TableField("report_member_name")
    private String reportMemberName;

    @TableField("report_object")
    private String reportObject;

    @ApiModelProperty("举报状态：0->未处理；1->已处理")
    @TableField("report_status")
    private Integer reportStatus;

    @ApiModelProperty("处理结果：0->无效；1->有效；2->恶意")
    @TableField("handle_status")
    private Integer handleStatus;

    @TableField("note")
    private String note;


}




