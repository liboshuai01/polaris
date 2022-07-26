package com.liboshuai.mall.tiny.domain.dao;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * <p>
 * 退货原因表
 * </p>
 *
 * @author liboshuai
 * @since 2022-07-26
 */
@Data
@TableName("oms_order_return_reason")
@ApiModel(value = "OmsOrderReturnReason对象", description = "退货原因表")
public class OmsOrderReturnReason implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    @ApiModelProperty("退货类型")
    @TableField("name")
    private String name;

    @TableField("sort")
    private Integer sort;

    @ApiModelProperty("状态：0->不启用；1->启用")
    @TableField("status")
    private Integer status;

    @ApiModelProperty("添加时间")
    @TableField("create_time")
    private LocalDateTime createTime;


}




