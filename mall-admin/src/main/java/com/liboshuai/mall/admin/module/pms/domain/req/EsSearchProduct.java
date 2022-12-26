package com.liboshuai.mall.admin.module.pms.domain.req;

import com.liboshuai.mall.admin.common.base.BasePageReq;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;


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
public class EsSearchProduct extends BasePageReq {
    private static final long serialVersionUID = -363540702161440897L;

    @ApiModelProperty("商品名称")
    private String name;

    @ApiModelProperty("副标题")
    private String subTitle;

    @ApiModelProperty("商品关键字")
    private String keywords;

}
