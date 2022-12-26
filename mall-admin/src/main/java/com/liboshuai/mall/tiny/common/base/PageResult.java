package com.liboshuai.mall.tiny.common.base;


import java.util.ArrayList;
import java.util.List;

/**
 * @Author: liboshuai
 * @Date: 2022-12-02 14:41
 * @Description: 手动分页对象
 */
public class PageResult<T> {
    /**
     * 当前页
     */
    private int pageNum;
    /**
     * 每页的数量
     */
    private int pageSize;
    /**
     * 是否分页
     */
    private boolean limitByPage;
    /**
     * 总数
     */
    private int total;
    /**
     * 分页数据，放入全部数据，返回分页数据（如果不分页则返回全部）
     */
    private List<T> list;

    public PageResult(Integer pageNum, Integer pageSize, Boolean limitByPage, List<T> list) {
        if(pageNum == null || pageSize == null || limitByPage == null || list == null){
            throw new RuntimeException("please check your params");
        }
        if(pageNum < 0 || pageSize < 0){
            throw new RuntimeException("pageNum or pageSize must be great than or equal to 0");
        }
        this.pageNum = pageNum;
        this.pageSize = pageSize;
        this.limitByPage = limitByPage;
        this.total = list.size();
        this.list = list;
        limitByPage();
    }

    private void limitByPage(){
        if(!limitByPage){
            return;
        }
        List<T> response = new ArrayList<>();
        //看看数据够不够
        if((pageNum-1) * pageSize <= total){
            int count = 1;
            for( int i = 0 ; i<list.size();i++){
                if(((pageNum-1) * pageSize -1 + count) < total &&  count <= pageSize){
                    response.add(list.get(((pageNum-1) * pageSize -1 + count)));
                    count++;
                }else{
                    break;
                }
            }
        }
        this.list = response;
    }

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

    public boolean isLimitByPage() {
        return limitByPage;
    }

    public void setLimitByPage(boolean limitByPage) {
        this.limitByPage = limitByPage;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public List<T> getList() {
        return list;
    }

    public void setList(List<T> list) {
        this.list = list;
    }
}