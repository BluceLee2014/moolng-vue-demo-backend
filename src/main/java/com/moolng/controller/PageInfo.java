package com.moolng.controller;

import lombok.Data;

import java.util.List;

@Data
public class PageInfo {
    private int total;
    private List<?> data;
    private Page page;


    public PageInfo(List<?> data, int total, RequestBese requestBese) {
        this.data = data;
        this.page = new Page(data, total, requestBese);
    }

}
