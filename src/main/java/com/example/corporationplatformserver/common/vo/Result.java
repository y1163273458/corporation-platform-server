package com.example.corporationplatformserver.common.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Result<T> {
    private Integer code;
    private String message;
    private T data;

    //成功
    public static <T> Result<T> success(){
        return new Result<>(20000, "success", null);
    }

    //带数据的成功
    public static <T> Result<T> success(T data) {
        return new Result<>(20000, "success", data);
    }

    //带数据和信息的成功
    public static <T> Result<T> success(T data,String message) {
        return new Result<>(20000, message, data);
    }

    //带特征码、数据和信息的成功
    public static <T> Result<T> success(Integer code,T data,String message) {
        return new Result<>(code, message, data);
    }

    //失败
    public static <T> Result<T> fail(){
        return new Result<>(30000, "fail", null);
    }
    //带错误码的失败
    public static <T> Result<T> fail(Integer code){
        return new Result<>(code, "fail", null);
    }
    //带错误码和信息的失败
    public static <T> Result<T> fail(Integer code,String message){
        return new Result<>(code, message, null);
    }
}
