package com.liboshuai.mall.admin.module.sms.domain.dao;

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
    * 限时购表
    * </p>
*
* @author liboshuai
* @since 2022-12-27
*/
    @Data
    @TableName("sms_flash_promotion")
    @ApiModel(value = "SmsFlashPromotion对象", description = "限时购表")
    public class SmsFlashPromotion implements Serializable {

    private static final long serialVersionUID = 1L;

            @TableId(value = "id", type = IdType.AUTO)
    private Long id;

        @TableField("title")
    private String title;

            @ApiModelProperty("开始日期")
        @TableField("start_date")
    private LocalDate startDate;

            @ApiModelProperty("结束日期")
        @TableField("end_date")
    private LocalDate endDate;

            @ApiModelProperty("上下线状态")
        @TableField("status")
    private Integer status;

            @ApiModelProperty("创建时间")
        @TableField("create_time")
    private LocalDateTime createTime;

            @ApiModelProperty("秒杀时间")
        @TableField("flash_sale_time")
    private LocalDateTime flashSaleTime;

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




