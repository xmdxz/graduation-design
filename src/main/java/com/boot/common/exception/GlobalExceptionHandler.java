package com.boot.common.exception;

import cn.hutool.core.text.CharSequenceUtil;
import com.boot.common.response.Response;
import com.boot.common.response.ResponseUtil;
import com.boot.common.response.ResultCode;
import com.fasterxml.jackson.core.JsonProcessingException;
import lombok.extern.log4j.Log4j2;
import org.springframework.validation.BindException;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.ConstraintViolationException;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @Author YuanXin
 * @ClassName GlobalExceptionHandler
 * @Description TODO
 * @Date 2022/8/12 10:00
 */

@RestControllerAdvice
@Log4j2
public class GlobalExceptionHandler {


    @ExceptionHandler({JsonProcessingException.class, ServiceException.class})
    public void handlePusherException(HttpServletResponse response, Exception exception) {
        String message = exception.getMessage();
        log.error("发生异常:" + message);
        ResponseUtil.outputResponse(response, ResponseUtil.error(ResultCode.FAILURE, message));
    }


    /**
     * 参数校验异常
     * 使用 @Valid 注解，方法上加@RequestBody注解修饰的方法未校验通过会抛MethodArgumentNotValidException，否则抛BindException
     *
     * @param request
     * @param e
     * @return
     */
    @ExceptionHandler({MethodArgumentNotValidException.class})
    public Response<?> handleMethodArgumentNotValidException(HttpServletRequest request, MethodArgumentNotValidException e) {
        log.error("execute method exception error.url is {}", request.getRequestURI(), e);
        List<ObjectError> allErrors = e.getBindingResult().getAllErrors();
        return ResponseUtil.error(ResultCode.PARAM_ERROR, allErrors.get(0).getDefaultMessage());
    }

    /**
     * 参数校验异常
     * 使用 @Valid 注解，方法上加@RequestBody注解修饰的方法未校验通过会抛MethodArgumentNotValidException，否则抛BindException
     *
     * @param request
     * @param e
     * @return
     */
    @ExceptionHandler({BindException.class})
    public Response<?> handleBindException(HttpServletRequest request, BindException e) {
        log.error("execute method exception error.url is {}", request.getRequestURI(), e);
        final String message = CharSequenceUtil.join("\n", e.getBindingResult().getAllErrors()
                .stream().map(ObjectError::getDefaultMessage).collect(Collectors.toList()));
        return ResponseUtil.error(ResultCode.PARAM_ERROR, message);
    }

    /**
     * 参数校验异常
     * 使用 @Validated 注解，未校验通过会抛ConstraintViolationException
     *
     * @param request
     * @param e
     * @return
     */
    @ExceptionHandler({ConstraintViolationException.class})
    public Response<?> handleConstraintViolationException(HttpServletRequest request, ConstraintViolationException e) {
        log.error("execute method exception error.url is {}", request.getRequestURI(), e);
        String[] split = e.getMessage().split(":");
        return ResponseUtil.error(ResultCode.PARAM_ERROR, split[split.length - 1]);
    }

}
