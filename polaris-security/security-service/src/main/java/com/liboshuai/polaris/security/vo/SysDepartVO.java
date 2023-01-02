package com.liboshuai.polaris.security.vo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.liboshuai.polaris.common.annotation.Dict;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;

/**
 * @Auther: Bernardo
 * @Date: 2023/1/2 17:23
 * @Description:
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ApiModel(value="部门vo对象", description="部门vo对象")
public class SysDepartVO implements Serializable {

    private static final long serialVersionUID = -4239286835948908184L;
    /**ID*/
    @ApiModelProperty("ID")
    private String id;

    /**父机构ID*/
    @ApiModelProperty("父机构ID")
    private String parentId;

    /**机构/部门名称*/
    @ApiModelProperty("机构/部门名称")
    private String departName;

    /**英文名*/
    @ApiModelProperty("英文名")
    private String departNameEn;

    /**缩写*/
    @ApiModelProperty("缩写")
    private String departNameAbbr;

    /**排序*/
    @ApiModelProperty("排序")
    private Integer departOrder;

    /**描述*/
    @ApiModelProperty("描述")
    private String description;

    /**机构类别 1=公司，2=组织机构，3=岗位*/
    @ApiModelProperty("机构类别 1=公司，2=组织机构，3=岗位")
    private String orgCategory;

    /**机构类型*/
    @ApiModelProperty("机构类型")
    private String orgType;

    /**机构编码*/
    @ApiModelProperty("机构编码")
    private String orgCode;

    /**手机号*/
    @ApiModelProperty("手机号")
    private String mobile;

    /**传真*/
    @ApiModelProperty("传真")
    private String fax;

    /**地址*/
    @ApiModelProperty("地址")
    private String address;

    /**备注*/
    @ApiModelProperty("备注")
    private String memo;

    /**状态（1启用，0不启用）*/
    @ApiModelProperty("状态（1启用，0不启用）")
    @Dict(dicCode = "depart_status")
    private String status;

    /**删除状态（0，正常，1已删除）*/
    @ApiModelProperty("删除状态（0，正常，1已删除）")
    @Dict(dicCode = "del_flag")
    private String delFlag;

    /**对接企业微信的ID*/
    @ApiModelProperty("对接企业微信的ID")
    private String qywxIdentifier;

    /**创建人*/
    @ApiModelProperty("创建人")
    private String createBy;

    /**创建日期*/
    @ApiModelProperty("创建日期")
    @JsonFormat(timezone = "GMT+8",pattern = "yyyy-MM-dd HH:mm:ss")
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private Date createTime;

    /**更新人*/
    @ApiModelProperty("更新人")
    private String updateBy;

    /**更新日期*/
    @ApiModelProperty("更新日期")
    @JsonFormat(timezone = "GMT+8",pattern = "yyyy-MM-dd HH:mm:ss")
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private Date updateTime;

    //update-begin---author:wangshuai ---date:20200308  for：[JTC-119]在部门管理菜单下设置部门负责人，新增字段负责人ids和旧的负责人ids
    /**部门负责人的ids*/
    @ApiModelProperty("部门负责人的ids")
    private String directorUserIds;

    /**旧的部门负责人的ids(用于比较删除和新增)*/
    @ApiModelProperty("旧的部门负责人的ids(用于比较删除和新增)")
    private String oldDirectorUserIds;

    //update-end---author:wangshuai ---date:20200308  for：[JTC-119]新增字段负责人ids和旧的负责人ids
}
