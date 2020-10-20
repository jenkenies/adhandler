package com.utstar.adhandler.vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Response<T> {

    public static final Integer RES_SUCCESS = 200;
    public static final String RES_SUCCESS_MSG = "success";
    public static final Integer RES_ERROR = 201;
    public static final String RES_ERROR_MSG = "system error";
    public static final Integer RES_PARAMS_ERROR = 202;
    public static final String RES_PARAMS_ERROR_MSG = "input params error";
    public static final Integer RES_DUPLICATE_ERROR = 203;
    public static final Integer RES_PARAMS_ERR = 204;
    private Integer code;
    private String msg;
    private T data;


    public static <T> Response createSuccess(T t) {
        return Response.builder().code(RES_SUCCESS).msg(RES_SUCCESS_MSG).data(t).build();
    }

    public static Response success() {
        return Response.builder().code(RES_SUCCESS).msg(RES_SUCCESS_MSG).build();
    }

    public static Response error() {
        return Response.builder().code(RES_ERROR).msg(RES_ERROR_MSG).build();
    }

    public static Response paramsError() {
        return Response.builder().code(RES_PARAMS_ERROR).msg(RES_PARAMS_ERROR_MSG).build();
    }

    public static Response duplicateError(String msg){
        return Response.builder().code(RES_DUPLICATE_ERROR).msg(msg).build();
    }

    public static <T> Response createError(String msg) {
        return Response.builder().code(RES_DUPLICATE_ERROR).msg(msg).data("").build();
    }

    public static Response paramsError(String msg) {
        return Response.builder().code(RES_PARAMS_ERR).msg(msg).data("").build();
    }

    public static <T> Response createError(Integer code, String msg) {
        return Response.builder().code(code).msg(msg).data("").build();
    }

    @Override
    public String toString() {
        return "Response{" +
                "code=" + code +
                ", msg='" + msg + '\'' +
                ", data=" + data +
                '}';
    }
}