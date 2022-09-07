package com.liboshuai.mall.tiny.module.cms.domain.dao;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * <p>
 * 用户举报表
 * </p>
 *
 * @author liboshuai
 * @since 2022-07-26
 */
@Data
@TableName("cms_member_report")
@ApiModel(value = "CmsMemberReport对象", description = "用户举报表")
public class CmsMemberReport implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableField("id")
    private Long id;

    @ApiModelProperty("举报类型：0->商品评价；1->话题内容；2->用户评论")
    @TableField("report_type")
    private Integer reportType;

    @ApiModelProperty("举报人")
    @TableField("report_member_name")
    private String reportMemberName;

    @TableField("create_time")
    private LocalDateTime createTime;

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




