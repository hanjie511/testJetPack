package com.example.testjetpack.model;

import org.json.JSONArray;

import java.util.List;

public class Translation {
    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public List getData() {
        return data;
    }

    public void setData(List data) {
        this.data = data;
    }

    private String code;
    private String msg;
    private List data;
}
