package com.liboshuai.mall.tiny.module.ums.domain.dao;

    import com.baomidou.mybatisplus.annotation.IdType;
    import com.baomidou.mybatisplus.annotation.TableField;
    import com.baomidou.mybatisplus.annotation.TableId;
    import com.baomidou.mybatisplus.annotation.TableName;
    import java.io.Serializable;
    import java.time.LocalDate;
    import java.time.LocalDateTime;
    import io.swagger.annotations.ApiModel;
    import io.swagger.annotations.ApiModelProperty;
    import lombok.Data;

/**
* <p>
    * 会员表
    * </p>
*
* @author liboshuai
* @since 2022-09-16
*/
    @Data
    @TableName("ums_member")
    @ApiModel(value = "UmsMember对象", description = "会员表")
    public class UmsMember implements Serializable {

    private static final long serialVersionUID = 1L;

            @TableId(value = "id", type = IdType.AUTO)
    private Long id;

        @TableField("member_level_id")
    private Long memberLevelId;

            @ApiModelProperty("用户名")
        @TableField("username")
    private String username;

            @ApiModelProperty("密码")
        @TableField("password")
    private String password;

            @ApiModelProperty("昵称")
        @TableField("nickname")
    private String nickname;

            @ApiModelProperty("手机号码")
        @TableField("phone")
    private String phone;

            @ApiModelProperty("帐号启用状态:0->禁用；1->启用")
        @TableField("status")
    private Integer status;

            @ApiModelProperty("头像")
        @TableField("icon")
    private String icon;

            @ApiModelProperty("性别：0->未知；1->男；2->女")
        @TableField("gender")
    private Integer gender;

            @ApiModelProperty("生日")
        @TableField("birthday")
    private LocalDate birthday;

            @ApiModelProperty("所做城市")
        @TableField("city")
    private String city;

            @ApiModelProperty("职业")
        @TableField("job")
    private String job;

            @ApiModelProperty("个性签名")
        @TableField("personalized_signature")
    private String personalizedSignature;

            @ApiModelProperty("用户来源")
        @TableField("source_type")
    private Integer sourceType;

            @ApiModelProperty("积分")
        @TableField("integration")
    private Integer integration;

            @ApiModelProperty("成长值")
        @TableField("growth")
    private Integer growth;

            @ApiModelProperty("剩余抽奖次数")
        @TableField("luckey_count")
    private Integer luckeyCount;

            @ApiModelProperty("历史积分数量")
        @TableField("history_integration")
    private Integer historyIntegration;

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




