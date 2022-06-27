package com.yikai.music.controller;

public class Result {
    private Integer code;
    private Object date;
    private String message;

    public Result() {
    }

    public Result(Integer code, Object date) {
        this.code = code;
        this.date = date;
    }

    public Result(Integer code, Object date, String message) {
        this.code = code;
        this.date = date;
        this.message = message;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public Object getDate() {
        return date;
    }

    public void setDate(Object date) {
        this.date = date;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
