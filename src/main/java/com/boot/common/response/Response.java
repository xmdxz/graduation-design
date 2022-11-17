package com.boot.common.response;

import lombok.Data;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;


//Restful风格下，全局请求返回结果封装，算是一个工具类，如若问起，是在网上寻找的解决方案
@Data
public class Response<T> implements Serializable {

    private static final long serialVersionUID = 5657560322950471121L;

    /**
     * 请求是否成功
     */
    private boolean success;

    /**
     * 请求返回的结果码,详情请看ResultCode类
     */
    private Integer code;

    /**
     * 结果返回所携带的信息
     */
    private String message;

    /**
     * 返回的真实数据
     */
    private T data;

    /**
     * 额外结果
     */
    private Map<String, Object> extra;

    /**
     * 构造函数
     * 成功且没有数据字段和额外数据字段
     *
     * @param message 响应的消息
     */
    public Response(String message) {
        this.success = true;
        this.code = 20000;
        this.message = message;
        this.data = null;
        this.extra = null;
    }

    /**
     * 构造函数
     * 自定状态码和消息，没有数据字段和额外数据字段
     *
     * @param success 是否成功
     * @param code    响应的状态码
     * @param message 响应的消息
     */
    public Response(boolean success, Integer code, String message) {
        this.success = success;
        this.code = code;
        this.message = message;
        this.data = null;
        this.extra = null;
    }

    /**
     * 构造函数
     * 自定状态码、消息和数据，没有额外数据字段
     *
     * @param success 是否成功
     * @param code    响应的状态码
     * @param message 响应的消息
     * @param data    响应的数据
     */
    public Response(boolean success, int code, String message, T data) {
        this.success = success;
        this.code = code;
        this.message = message;
        this.data = data;
        this.extra = null;
    }

    /**
     * 构造函数
     * 自定状态码、消息、数据和额外数据
     *
     * @param success 是否成功
     * @param code    响应的状态码
     * @param message 响应的消息
     * @param data    响应的数据
     * @param extra   响应的额外数据
     */
    public Response(boolean success, int code, String message, T data, Map<String, Object> extra) {
        this.success = success;
        this.code = code;
        this.message = message;
        this.data = data;
        this.extra = extra;
    }

    /**
     * 构造函数
     * 使用通用状态码,没有数据和额外数据
     *
     * @param success 是否成功
     * @param code    通用状态码
     */
    public Response(boolean success, BaseCode code) {
        this.success = success;
        this.code = code.getCode();
        this.message = code.getMessage();
        this.data = null;
        this.extra = null;
    }

    /**
     * 构造函数
     * 使用通用状态码,没有数据和额外数据
     *
     * @param success 是否成功
     * @param code    通用状态码
     */
    public Response(boolean success, BaseCode code, String msg) {
        this.success = success;
        this.code = code.getCode();
        this.message = msg;
        this.data = null;
        this.extra = null;
    }

    /**
     * 构造函数
     * 使用通用状态码和数据，没有额外数据
     *
     * @param success 是否成功
     * @param code    通用状态码
     * @param data    响应的数据
     */
    public Response(boolean success, BaseCode code, T data) {
        this.success = success;
        this.code = code.getCode();
        this.message = code.getMessage();
        this.data = data;
        this.extra = null;
    }

    /**
     * 构造函数
     * 使用通用状态码、数据和额外数据
     *
     * @param success 是否成功
     * @param code    通用状态码
     * @param data    响应的数据
     * @param extra   响应的额外数据
     */
    public Response(boolean success, BaseCode code, T data, Map<String, Object> extra) {
        this.success = success;
        this.code = code.getCode();
        this.message = code.getMessage();
        this.data = data;
        this.extra = extra;
    }

    /**
     * 增加额外数据
     *
     * @param key   数据的键
     * @param value 数据的值
     */
    public void addExtra(String key, Object value) {
        extra = extra == null ? new HashMap<>(16) : extra;
        extra.put(key, value);
    }

    /**
     * 如果条件为真则增加额外数据
     *
     * @param condition 判断条件
     * @param key       数据的键
     * @param value     数据的值
     */
    public void addExtraIfTrue(boolean condition, String key, Object value) {
        if (condition) {
            addExtra(key, value);
        }
    }

}
