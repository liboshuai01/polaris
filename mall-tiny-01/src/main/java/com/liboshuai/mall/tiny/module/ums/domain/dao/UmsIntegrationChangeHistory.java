package com.liboshuai.mall.tiny.module.ums.domain.dao;

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
 * 积分变化历史记录表
 * </p>
 *
 * @author liboshuai
 * @since 2022-07-26
 */
@Data
@TableName("ums_integration_change_history")
@ApiModel(value = "UmsIntegrationChangeHistory对象", description = "积分变化历史记录表")
public class UmsIntegrationChangeHistory implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    @TableField("member_id")
    private Long memberId;

    @TableField("create_time")
    private LocalDateTime createTime;

    @ApiModelProperty("改变类型：0->增加；1->减少")
    @TableField("change_type")
    private Integer changeType;

    @ApiModelProperty("积分改变数量")
    @TableField("change_count")
    private Integer changeCount;

    @ApiModelProperty("操作人员")
    @TableField("operate_man")
    private String operateMan;

    @ApiModelProperty("操作备注")
    @TableField("operate_note")
    private String operateNote;

    @ApiModelProperty("积分来源：0->购物；1->管理员修改")
    @TableField("source_type")
    private Integer sourceType;


}




