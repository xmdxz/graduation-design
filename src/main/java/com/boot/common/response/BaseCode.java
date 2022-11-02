package com.boot.common.response;


/**
 * @author YuanXin
 */
public interface BaseCode {

    /**
     * 状态码的code
     *
     * @return Integer
     */
    Integer getCode();

    /**
     * 状态码的message
     *
     * @return String
     */
    String getMessage();

}