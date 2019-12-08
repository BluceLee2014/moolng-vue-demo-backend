package com.moolng.controller;

import lombok.Data;

@Data
public class ResponseInfo {

    private int code;
    private String msg;
    private int total;

    public void successResponseInfo(int total) {
        this.code = 200;
        this.msg = "成功";
        this.total = total;
    }

    public void errorResponseInfo() {
        this.code = 500;
        this.msg = "失败";
    }
}
