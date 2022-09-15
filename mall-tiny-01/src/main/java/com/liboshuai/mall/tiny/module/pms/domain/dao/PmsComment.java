package com.liboshuai.mall.tiny.module.pms.domain.dao;

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
    * 商品评价表
    * </p>
*
* @author liboshuai
* @since 2022-09-16
*/
    @Data
    @TableName("pms_comment")
    @ApiModel(value = "PmsComment对象", description = "商品评价表")
    public class PmsComment implements Serializable {

    private static final long serialVersionUID = 1L;

            @TableId(value = "id", type = IdType.AUTO)
    private Long id;

        @TableField("product_id")
    private Long productId;

        @TableField("member_nick_name")
    private String memberNickName;

        @TableField("product_name")
    private String productName;

            @ApiModelProperty("评价星数：0->5")
        @TableField("star")
    private Integer star;

            @ApiModelProperty("评价的ip")
        @TableField("member_ip")
    private String memberIp;

        @TableField("show_status")
    private Integer showStatus;

            @ApiModelProperty("购买时的商品属性")
        @TableField("product_attribute")
    private String productAttribute;

        @TableField("collect_couont")
    private Integer collectCouont;

        @TableField("read_count")
    private Integer readCount;

        @TableField("content")
    private String content;

            @ApiModelProperty("上传图片地址，以逗号隔开")
        @TableField("pics")
    private String pics;

            @ApiModelProperty("评论用户头像")
        @TableField("member_icon")
    private String memberIcon;

        @TableField("replay_count")
    private Integer replayCount;

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




