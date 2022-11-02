package com.boot.dto.common.ro;

import com.boot.common.enums.EndpointEnum;
import lombok.Data;

import javax.validation.constraints.Size;

/**
 * @Author YuanXin
 * @ClassName PhoneLoginRo
 * @Description TODO
 * @Date 2022/9/7 16:20
 */

@Data
public class PhoneLoginRo {

    @Size(min = 11, max = 11, message = "手机号格式有误")
    private String phone;

    private EndpointEnum endpoint;
}
