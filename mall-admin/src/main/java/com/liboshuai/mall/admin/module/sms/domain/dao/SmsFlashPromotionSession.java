package com.liboshuai.mall.admin.module.sms.domain.dao;

    import com.baomidou.mybatisplus.annotation.IdType;
    import com.baomidou.mybatisplus.annotation.TableField;
    import com.baomidou.mybatisplus.annotation.TableId;
    import com.baomidou.mybatisplus.annotation.TableName;
    import java.io.Serializable;
    import java.time.LocalDateTime;
    import java.time.LocalTime;
    import io.swagger.annotations.ApiModel;
    import io.swagger.annotations.ApiModelProperty;
    import lombok.Data;

/**
* <p>
    * 限时购场次表
    * </p>
*
* @author liboshuai
* @since 2022-12-27
*/
    @Data
    @TableName("sms_flash_promotion_session")
    @ApiModel(value = "SmsFlashPromotionSession对象", description = "限时购场次表")
    public class SmsFlashPromotionSession implements Serializable {

    private static final long serialVersionUID = 1L;

            @ApiModelProperty("编号")
            @TableId(value = "id", type = IdType.AUTO)
    private Long id;

            @ApiModelProperty("场次名称")
        @TableField("name")
    private String name;

            @ApiModelProperty("每日开始时间")
        @TableField("start_time")
    private LocalTime startTime;

            @ApiModelProperty("每日结束时间")
        @TableField("end_time")
    private LocalTime endTime;

            @ApiModelProperty("启用状态：0->不启用；1->启用")
        @TableField("status")
    private Integer status;

            @ApiModelProperty("创建时间")
        @TableField("create_time")
    private LocalDateTime createTime;

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




