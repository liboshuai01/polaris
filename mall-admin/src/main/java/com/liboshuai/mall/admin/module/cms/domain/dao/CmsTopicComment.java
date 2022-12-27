package com.liboshuai.mall.admin.module.cms.domain.dao;

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
    * 专题评论表
    * </p>
*
* @author liboshuai
* @since 2022-12-27
*/
    @Data
    @TableName("cms_topic_comment")
    @ApiModel(value = "CmsTopicComment对象", description = "专题评论表")
    public class CmsTopicComment implements Serializable {

    private static final long serialVersionUID = 1L;

            @TableId(value = "id", type = IdType.AUTO)
    private Long id;

        @TableField("member_nick_name")
    private String memberNickName;

        @TableField("topic_id")
    private Long topicId;

        @TableField("member_icon")
    private String memberIcon;

        @TableField("content")
    private String content;

            @ApiModelProperty("创建时间")
        @TableField("create_time")
    private LocalDateTime createTime;

        @TableField("show_status")
    private Integer showStatus;

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




