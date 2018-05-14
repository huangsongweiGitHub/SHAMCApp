package com.nantian.shamc.approval.dto;

/**
 * Created by huang on 2018/5/14.
 */


public class PageInfo{
    /**
     * currentPage : 1
     * pageCount : 0
     * pageSize : 10
     * count : 0
     * isMsg : 1
     */

    private int currentPage;
    private int pageCount;
    private int pageSize;
    private int count;
    private int isMsg;

    public int getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }

    public int getPageCount() {
        return pageCount;
    }

    public void setPageCount(int pageCount) {
        this.pageCount = pageCount;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public int getIsMsg() {
        return isMsg;
    }

    public void setIsMsg(int isMsg) {
        this.isMsg = isMsg;
    }
}
