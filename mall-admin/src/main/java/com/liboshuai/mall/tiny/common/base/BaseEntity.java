package com.liboshuai.mall.tiny.common.base;

import com.baomidou.mybatisplus.annotation.*;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Date;

/**
 * @Author: liboshuai
 * @Date: 2022-09-14 18:09
 * @Description: 通用DAO类
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class BaseEntity implements Serializable {

    private static final long serialVersionUID = 3812542271764882944L;

    @ApiModelProperty("主键id")
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    @ApiModelProperty("创建用户")
    @TableField(value = "create_user", fill = FieldFill.INSERT)
    private String createUser;

    @ApiModelProperty("创建时间")
    @TableField(value = "create_time", fill = FieldFill.INSERT)
    private Date createTime;

    @ApiModelProperty("更新用户")
    @TableField(value = "update_user", fill = FieldFill.UPDATE)
    private String updateUser;

    @ApiModelProperty("更新时间")
    @TableField(value = "update_time", fill = FieldFill.UPDATE)
    private Date updateTime;

    @ApiModelProperty("是否被逻辑删除 0-未被删除 1-已被删除")
    @TableField("is_delete")
    @TableLogic
    private String isDelete;

}
