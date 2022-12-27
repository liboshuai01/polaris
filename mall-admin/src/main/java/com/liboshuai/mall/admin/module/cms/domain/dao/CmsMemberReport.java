package com.liboshuai.mall.admin.module.cms.domain.dao;

    import com.baomidou.mybatisplus.annotation.TableField;
    import com.baomidou.mybatisplus.annotation.TableName;
    import java.io.Serializable;
    import java.time.LocalDateTime;
    import io.swagger.annotations.ApiModel;
    import io.swagger.annotations.ApiModelProperty;
    import lombok.Data;

/**
* <p>
    * 用户举报表
    * </p>
*
* @author liboshuai
* @since 2022-12-27
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

            @ApiModelProperty("创建时间")
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

            @ApiModelProperty("创建用户")
        @TableField("create_user")
    private String createUser;

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




