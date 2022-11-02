package com.boot.common.exception;

import com.boot.common.response.BaseCode;
import com.boot.common.response.ResultCode;

/**
 * @Author YuanXin
 * @ClassName NeedPusherException
 * @Description TODO
 * @Date 2022/10/17 9:46
 */
public class NeedPusherException extends RuntimeException {

    private static final long serialVersionUID = -412302766008471476L;

    private final BaseCode code;

    private final String msg;

    /**
     * 构造函数
     * 传入异常消息
     * 返回码默认为ResultCode.FAILURE
     *
     * @param message 异常消息
     */
    public NeedPusherException(String message) {
        super(message);
        this.msg = message;
        this.code = ResultCode.FAILURE;
    }

    /**
     * 构造函数
     * 使用通用状态码新建异常
     *
     * @param code 异常码
     */
    public NeedPusherException(BaseCode code) {
        super(code.getMessage());
        this.code = code;
        this.msg = code.getMessage();
    }

    /**
     * 构造函数
     * 自定义异常消息和返回码
     *
     * @param message 异常消息
     * @param code    异常码
     */
    public NeedPusherException(BaseCode code, String message) {
        super(message);
        this.code = code;
        this.msg = message;
    }

    public BaseCode getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }
}
