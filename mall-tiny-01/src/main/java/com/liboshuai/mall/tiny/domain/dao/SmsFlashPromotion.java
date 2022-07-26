package com.liboshuai.mall.tiny.domain.dao;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * <p>
 * 限时购表
 * </p>
 *
 * @author liboshuai
 * @since 2022-07-26
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

    @ApiModelProperty("秒杀时间段名称")
    @TableField("create_time")
    private LocalDateTime createTime;


}




