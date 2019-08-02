package com.bosch.util;

/**
 * @program: demo
 * @description: 枚举常用操作码
 * @author: wjy
 * @create: 2019-06-12 10:08
 */

public enum ResultCode {
    SUCCESS(200, "操作成功"),
    FILE_FORMAT_FAILED(202,"文件格式错误"),
    FAILED(500, "操作失败"),
    VALIDATE_FAILED(404, "参数检验失败"),
    UNAUTHORIZED(401, "暂未登录或token已经过期"),
    FORBIDDEN(403, "没有相关权限");
    private long code;
    private String message;

    ResultCode(long code, String message) {
        this.code = code;
        this.message = message;
    }

    public long getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message){
        this.message = message;
    }
}