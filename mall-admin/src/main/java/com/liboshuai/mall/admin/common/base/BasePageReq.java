package com.liboshuai.mall.admin.common.base;

import java.io.Serializable;

/**
 * @Author: liboshuai
 * @Date: 2022-12-02 17:31
 * @Description: 基础分页查询请求入参对象
 */
public class BasePageReq implements Serializable {
    private static final long serialVersionUID = -1718844207933698003L;

    private int pageNum;

    private int pageSize;


    public int getPageNum() {
        return pageNum;
    }

    public void setPageNum(int pageNum) {
        this.pageNum = pageNum;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }
}
