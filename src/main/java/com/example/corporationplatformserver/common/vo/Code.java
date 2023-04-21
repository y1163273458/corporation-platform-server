package com.example.corporationplatformserver.common.vo;

/**
 * 规定:
 * #20000～29999 区间表示成功
 * #30000～39999 区间表示错误
 * 统一错误枚举类
 */
public enum Code {
    //成功
    SUCCESS_SELECT(20000,"查询成功"),
    SUCCESS_UPDATE(20001,"更新成功"),
    SUCCESS_SELECT_CORP(20100,"查询到社团用户"),

    //失败
    FAIL_SELECT(30000,"查询失败"),
    FAIL_UPDATE(30001,"更新失败");

    private int code;
    private String message;//中文描述

    Code(int code, String message) {
        this.code = code;
        this.message = message;
    }
    //get方法
    public Integer getCode() {
        return code;
    }

    //set方法
    public Code setCode(Integer code) {
        this.code = code;
        return this;
    }

    public String getMessage() {
        return message;
    }

    public Code setMessage(String message) {
        this.message = message;
        return this;
    }

    /**
     * 根据code获取message
     *
     * @param code 状态码
     * @return String
     */
    public static String getMessageByCode(Integer code) {
        for (Code ele : values()) {
            if (ele.getCode().equals(code)) {
                return ele.getMessage();
            }
        }
        return null;
    }
}
