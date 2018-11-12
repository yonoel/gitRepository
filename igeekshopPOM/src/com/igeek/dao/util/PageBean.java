package com.igeek.dao.util;

import java.io.Serializable;
import java.util.List;

/**
 * @ClassName: PageBean
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @date 2018年7月26日 下午8:03:47
 * 
 */
public class PageBean<T> implements Serializable {
    /**
     * @Fields serialVersionUID : TODO(用一句话描述这个变量表示什么)
     */
    private static final long serialVersionUID = -8248370309686697880L;
    private int pagenum;
    private int dataCount;
    private int pageSize = 10;
    private int pageCount;
    private int index;

    private List<T> list;

    public int getPagenum() {
        return pagenum;
    }

    public void setPagenum(int pagenum) {
        this.pagenum = pagenum;
    }

    public int getDataCount() {
        return dataCount;
    }

    public void setDataCount(int dataCount) {
        this.dataCount = dataCount;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getPageCount() {
        if (dataCount % pageSize == 0) {
            pageCount = dataCount / pageSize;
        } else {
            pageCount = dataCount / pageSize + 1;
        }
        return pageCount;
    }

    public void setPageCount(int pageCount) {
        this.pageCount = pageCount;
    }

    public int getIndex() {
        index = (pagenum - 1) * pageSize;
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public List<T> getList() {
        return list;
    }

    public void setList(List<T> list) {
        this.list = list;
    }

    public PageBean() {
        super();
    }

    public PageBean(int pagenum, int dataCount) {
        super();
        this.pagenum = pagenum;
        this.dataCount = dataCount;
    }
}
