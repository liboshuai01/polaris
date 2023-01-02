package com.liboshuai.polaris.security.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @Auther: Bernardo
 * @Date: 2023/1/2 21:49
 * @Description:
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SysDepartDTO implements Serializable {

    private static final long serialVersionUID = -493567109886012965L;
    /**
     * 父机构ID
     */
    private String parentId;

    /**
     * 机构/部门名称
     */
    private String departName;

    /**
     * 英文名
     */
    private String departNameEn;

    /**
     * 缩写
     */
    private String departNameAbbr;

    /**
     * 排序
     */
    private Integer departOrder;

    /**
     * 描述
     */
    private String description;

    /**
     * 机构类别 1公司，2组织机构，2岗位
     */
    private String orgCategory;

    /**
     * 机构类型 1一级部门 2子部门
     */
    private String orgType;

    /**
     * 机构编码
     */
    private String orgCode;

    /**
     * 手机号
     */
    private String mobile;

    /**
     * 传真
     */
    private String fax;

    /**
     * 地址
     */
    private String address;

    /**
     * 备注
     */
    private String memo;

    /**
     * 状态（1启用，0不启用）
     */
    private String status;

    /**
     * 删除状态（0，正常，1已删除）
     */
    private String delFlag;

    /**
     * 对接企业微信的ID
     */
    private String qywxIdentifier;
}
