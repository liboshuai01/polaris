package com.liboshuai.mall.tiny.module.pms.domain.req;

import com.liboshuai.mall.tiny.common.base.BasePageReq;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;

import java.math.BigDecimal;

/**
 * @Author: liboshuai
 * @Date: 2022-12-02 17:49
 * @Description: 商品搜索入参对象
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class ProductSearchReq extends BasePageReq {
    private static final long serialVersionUID = -363540702161440897L;

    @ApiModelProperty("商品名称")
    private String name;

    @ApiModelProperty("商品价格")
    private BigDecimal price;

    @ApiModelProperty("副标题")
    private String subTitle;

    @ApiModelProperty("商品描述")
    private String description;

    @ApiModelProperty("单位")
    private String unit;

    @ApiModelProperty("商品重量，默认为克")
    private BigDecimal weight;

    @ApiModelProperty("商品关键字")
    private String keywords;

    @ApiModelProperty("商品备注")
    private String note;

}
