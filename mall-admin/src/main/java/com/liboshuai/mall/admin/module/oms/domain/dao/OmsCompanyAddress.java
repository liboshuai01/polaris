package com.liboshuai.mall.admin.module.oms.domain.dao;

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
    * 公司收发货地址表
    * </p>
*
* @author liboshuai
* @since 2022-12-27
*/
    @Data
    @TableName("oms_company_address")
    @ApiModel(value = "OmsCompanyAddress对象", description = "公司收发货地址表")
    public class OmsCompanyAddress implements Serializable {

    private static final long serialVersionUID = 1L;

            @TableId(value = "id", type = IdType.AUTO)
    private Long id;

            @ApiModelProperty("地址名称")
        @TableField("address_name")
    private String addressName;

            @ApiModelProperty("默认发货地址：0->否；1->是")
        @TableField("send_status")
    private Integer sendStatus;

            @ApiModelProperty("是否默认收货地址：0->否；1->是")
        @TableField("receive_status")
    private Integer receiveStatus;

            @ApiModelProperty("收发货人姓名")
        @TableField("name")
    private String name;

            @ApiModelProperty("收货人电话")
        @TableField("phone")
    private String phone;

            @ApiModelProperty("省/直辖市")
        @TableField("province")
    private String province;

            @ApiModelProperty("市")
        @TableField("city")
    private String city;

            @ApiModelProperty("区")
        @TableField("region")
    private String region;

            @ApiModelProperty("详细地址")
        @TableField("detail_address")
    private String detailAddress;

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

            @ApiModelProperty("逻辑删除: 0-未删除, 1-已删除")
        @TableField("is_delete")
    private String isDelete;


}




