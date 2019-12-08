package com.moolng.controller;

import lombok.Data;

import java.util.List;

@Data
public class Page {

    private int current;
    private int total;
    private int pageSize;

    public Page(List<?> data, int total, RequestBese requestBese) {
        this.current = requestBese.getCurrent();
        this.pageSize = requestBese.getPageSize();
        this.total = total;
    }
}
