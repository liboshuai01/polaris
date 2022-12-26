package com.liboshuai.mall.tiny.module.ums.domain.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.liboshuai.mall.tiny.common.base.BaseEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

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
public class UmsMemberLoginLog extends BaseEntity {

    private static final long serialVersionUID = 1L;

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

}




