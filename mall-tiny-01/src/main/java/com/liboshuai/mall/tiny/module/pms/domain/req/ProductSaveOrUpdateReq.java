package com.liboshuai.mall.tiny.module.pms.domain.req;

import com.baomidou.mybatisplus.annotation.TableField;
import com.liboshuai.mall.tiny.common.base.BasePageReq;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;

import java.io.Serializable;


/**
 * @Author: liboshuai
 * @Date: 2022-12-02 17:29
 * @Description: 添加或修改商品的请求对象
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProductSaveOrUpdateReq implements Serializable {
    private static final long serialVersionUID = -1516026568844827396L;

    @ApiModelProperty("商品名称")
    private String name;

    @ApiModelProperty("商品价格")
    private String pic;

    @ApiModelProperty("副标题")
    private String subTitle;

    @ApiModelProperty("商品描述")
    private String description;

    @ApiModelProperty("商品关键字")
    private String keywords;

    @ApiModelProperty("商品备注")
    private String note;
}