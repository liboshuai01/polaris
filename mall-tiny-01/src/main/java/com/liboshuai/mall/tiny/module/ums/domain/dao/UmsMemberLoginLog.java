package com.liboshuai.mall.tiny.module.ums.domain.dao;

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
    * 会员登录记录
    * </p>
*
* @author liboshuai
* @since 2022-09-16
*/
    @Data
    @TableName("ums_member_login_log")
    @ApiModel(value = "UmsMemberLoginLog对象", description = "会员登录记录")
    public class UmsMemberLoginLog implements Serializable {

    private static final long serialVersionUID = 1L;

            @TableId(value = "id", type = IdType.AUTO)
    private Long id;

        @TableField("member_id")
    private Long memberId;

        @TableField("ip")
    private String ip;

        @TableField("city")
    private String city;

            @ApiModelProperty("登录类型：0->PC；1->android;2->ios;3->小程序")
        @TableField("login_type")
    private Integer loginType;

        @TableField("province")
    private String province;

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




