package com.liboshuai.mall.tiny.common.base;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

/**
 * @Author: liboshuai
 * @Date: 2022-09-14 18:09
 * @Description: 通用DAO类
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BaseDAO implements Serializable {

    private static final long serialVersionUID = 3812542271764882944L;

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    @TableField(value = "create_user", fill = FieldFill.INSERT)
    private String createUser;

    @TableField(value = "create_time", fill = FieldFill.INSERT)
    private Date createTime;

    @TableField(value = "update_user", fill = FieldFill.UPDATE)
    private String updateUser;

    @TableField(value = "update_time", fill = FieldFill.UPDATE)
    private Date updateTime;
}
