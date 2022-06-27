package com.yikai.music.controller;

public class PageResult {

    private Long totalCount;

    private Long pages;

    private Object list;

    public Long getPages() {
        return pages;
    }

    public void setPages(Long pages) {
        this.pages = pages;
    }

    public Object getList() {
        return list;
    }

    public Long getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(Long totalCount) {
        this.totalCount = totalCount;
    }

    public void setList(Object list) {
        this.list = list;
    }
}
