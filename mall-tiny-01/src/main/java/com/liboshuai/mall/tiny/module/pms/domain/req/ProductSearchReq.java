package com.liboshuai.mall.tiny.module.pms.domain.req;

import com.liboshuai.mall.tiny.common.base.BasePageReq;
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
public class ProductSearchReq extends BasePageReq {
    private static final long serialVersionUID = -363540702161440897L;


}
