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
    * 成长值变化历史记录表
    * </p>
*
* @author liboshuai
* @since 2022-09-16
*/
    @Data
    @TableName("ums_growth_change_history")
    @ApiModel(value = "UmsGrowthChangeHistory对象", description = "成长值变化历史记录表")
    public class UmsGrowthChangeHistory implements Serializable {

    private static final long serialVersionUID = 1L;

            @TableId(value = "id", type = IdType.AUTO)
    private Long id;

        @TableField("member_id")
    private Long memberId;

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




