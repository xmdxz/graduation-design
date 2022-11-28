package com.boot.exception;

import com.boot.common.response.BaseCode;
import com.boot.common.response.ResultCode;


//自定义异常，业务逻辑发生异常后可用此异常抛出，他是运行时异常
public class ServiceException extends RuntimeException {

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
    public ServiceException(String message) {
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
    public ServiceException(BaseCode code) {
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
    public ServiceException(BaseCode code, String message) {
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
