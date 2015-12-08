package com.web.common;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author jayson  <br/> 2015-12-01 21:20
 * @since v1.0
 */
@Component("Page")
@Scope("prototype")
public class Page<T> {
    private int curPage;
    private int pageSize;
    private int total;
    private List<T> list;

    public int getStart(){
        return (curPage - 1) * pageSize + 1;
    }

    public int getEnd(){
        return curPage * pageSize > total ? total : curPage * pageSize;
    }

    public int getTotalPages(){
        return total % pageSize == 0 ? total / pageSize : total / pageSize + 1;
    }

    /**getter、setter方法**/
    public int getCurPage() {
        return curPage;
    }

    public void setCurPage(int curPage) {
        this.curPage = curPage;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
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
