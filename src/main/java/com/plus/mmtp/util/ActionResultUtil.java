package com.plus.mmtp.util;

import java.io.Serializable;

/**
 * @ClassName: ActionResultUtil
 * @Description: 分页工具类
 * @Auther: ch
 * @Date: 2018/9/15 19:06
 * @Version: 1.0
 **/
public class ActionResultUtil<T> implements Serializable {

    private Integer page;
    private Integer total;
    private T rows;

    public ActionResultUtil() {
    }

    public ActionResultUtil(Integer page, Integer total, T rows) {
        this.page = page;
        this.total = total;
        this.rows = rows;
    }

    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    public T getRows() {
        return rows;
    }

    public void setRows(T rows) {
        this.rows = rows;
    }
}
