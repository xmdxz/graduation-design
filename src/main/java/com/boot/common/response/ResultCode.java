package com.boot.common.response;


/**
 * @author YuanXin
 */

public enum ResultCode implements BaseCode {

    /**
     * 处理成功
     */
    OK(20000, "处理成功"),

    /**
     * 未认证
     */
    UNAUTHENTICATED(40000, "未认证"),

    /**
     * 未授权
     */
    UNAUTHORIZED(40001, "未授权"),

    /**
     * 失败
     */
    FAILURE(40002, "业务异常"),

    /**
     * 账户不存在
     */
    ACCOUNT_NOT_FOUNT(40003, "账号不存在，请重新输入"),

    /**
     * 账户已在其他地点登录
     */
    ACCOUNT_LOGIN_IN_OTHER_PLACE(40004, "账号已在其他地点登录"),

    /**
     * 用户权限已更改
     */
    ACCOUNT_PERMISSION_CHANGED(40005, "账号信息发生了变更，请重新登录"),

    /**
     * 该用户已被禁用, 请联系机构管理员
     */
    ACCOUNT_FORBIDDEN(40006, "该用户已被禁用, 请联系机构管理员"),
    /**
     * 该用户已被禁用, 请联系机构管理员
     */
    SPECIAL_URL(40007, ""),

    /**
     * Token 解析失败
     */
    TOKEN_DECODE(40010, "登录超时，请重新登录"),

    /**
     * 参数不合法
     */
    PARAM_ERROR(40012, "参数不合法"),

    /**
     * 图片验证码生成错误
     */
    GRAPH_CODE_CREATE_ERROR(40013, "图片验证码生成错误"),

    /**
     * 图形验证码错误
     */
    GRAPH_CODE_VERIFY_ERROR(40014, "图形验证码错误"),

    /**
     * 短信模板不存在
     */
    SMS_CODE_TPL_NOT_EXIST(40015, "短信模板不存在"),

    /**
     * 获取手机验证码太频繁
     */
    PHONE_CODE_CREATE_FREQUENT(40016, "获取手机验证码太频繁"),

    /**
     * 手机验证码发送异常
     */
    PHONE_CODE_SEND_ERROR(40017, "手机验证码发送异常"),

    /**
     * 手机验证码错误
     */
    PHONE_CODE_VERIFY_ERROR(40018, "手机验证码错误"),
    /**
     * 获取施强嘉善用户信息失败
     */
    JIASHAN_CHECK_FAIL(40022, "获取施强嘉善用户信息失败"),
    /**
     * 该订单不属于本用户
     */
    ORDER_CHECK(40022, "该订单不属于本用户"),

    /**
     * 验证码过期
     */
    PHONE_CODE_EXPIRE_TIME(40019, "验证码过期，请重新获取"),

    /**
     * 手机号已修改
     */
    PHONE_CHANGED(40020, "手机号已修改, 请重新登录"),
    /**
     * 业务异常
     */
    BIZ_EXCEPTION(50001, "业务异常"),

    /**
     * 机构不存在, 为移动端机构详情接口使用
     */
    ORG_NOT_EXIST(50002, "机构不存在"),

    /**
     * 服务器内部错误
     */
    INTERNAL_SERVER_ERROR(50000, "服务器内部错误"),

    BIZ_ICBC_INVOKE_ERROR(60000, "中国工商银行调用响应错误"),

    BIZ_BOC_INVOKE_ERROR(60001, "中国银行调用响应错误");


    private final Integer code;
    private final String message;

    ResultCode(int code, String message) {
        this.code = code;
        this.message = message;
    }

    @Override
    public Integer getCode() {
        return code;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
