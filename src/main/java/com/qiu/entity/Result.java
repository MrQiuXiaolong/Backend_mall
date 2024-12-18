package com.qiu.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Result<T> implements Serializable { /*实现Serializable接口 可以实现序列化和反序列化*/

    private static final long serialVersionUID = 5187687995319002219L;
    /**
     * 响应码
     */
    private Integer code;
    /**
     * 标识操作是否成功
     */
    private Boolean success;
    /**
     * 响应的消息
     */
    private String message;
    /**
     * 响应的数据
     */
    private T data;

    /**
     * 通用方法
     * @param code 响应码
     * @param message 消息
     * @param success 是否成功
     * @param data 数据
     * @return 返回的结果
     * @param <T> 任何类型
     */
    public static <T> Result<T> definition(int code, String message, Boolean success, T data) {
        Result<T> r = new Result<>();
        r.setCode(code);
        r.setSuccess(success);
        r.setMessage(message);
        r.setData(data);
        return r;
    }

    /**
     * 成功 200 的返回
     * @param message 返回消息
     * @param data 返回数据
     * @return 返回的结果
     * @param <T> 任何类型
     */
    public static <T> Result<T> ok(String message, T data) {
        Result<T> r = new Result<>();
        r.setCode(200);
        r.setMessage(message);
        r.setSuccess(true);
        r.setData(data);
        return r;
    }

    /**
     * 成功 200 消息 返回 只需要传入一个返回的data
     * @param data 返回的数据
     * @return 返回的结果
     * @param <T> 任何类型
     */
    public static <T> Result<T> ok(T data) {
        Result<T> r = new Result<>();
        r.setCode(200);
        r.setMessage("操作成功");
        r.setSuccess(true);
        r.setData(data);
        return r;
    }

    /**
     * 成功 200 无返回数据 只需要传入一个返回的消息
     * @param message 消息
     * @return 返回的结果
     * @param <T> 任何类型
     */
    public static <T> Result<T> ok(String message) {
        Result<T> r = new Result<>();
        r.setCode(200);
        r.setSuccess(true);
        r.setMessage(message);
        return r;
    }

    /**
     * 返回 200 消息 无类型
     * @return 返回的结果
     * @param <T> 任何类型
     */
    public static <T> Result<T> ok() {
        Result<T> r = new Result<>();
        r.setCode(200);
        r.setSuccess(true);
        r.setMessage("操作成功");
        return r;
    }

    /**
     * 返回 500 消息
     * @return 返回的结果
     * @param <T> 任何类型
     */
    public static <T> Result<T> error() {
        Result<T> r = new Result<>();
        r.setCode(500);
        r.setSuccess(false);
        r.setMessage("操作失败");
        return r;
    }

    /**
     * 返回500 需要自己传入消息
     * @param message 消息
     * @return 返回的结果
     * @param <T> 任何类型
     */
    public static <T> Result<T> error(String message) {
        Result<T> r = new Result<>();
        r.setCode(500);
        r.setSuccess(false);
        r.setMessage(message);
        return r;
    }

    /**
     * 需自定义返回的响应码 消息
     * @param code 响应码
     * @param message 消息
     * @return 返回的结果
     * @param <T> 任何类型
     */
    public static <T> Result<T> error(int code, String message) {
        Result<T> r = new Result<>();
        r.setCode(code);
        r.setSuccess(false);
        r.setMessage(message);
        return r;
    }

}