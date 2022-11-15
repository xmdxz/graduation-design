package com.boot.dto.ro;

import com.boot.common.enums.Type;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * @Author YuanXin
 * @ClassName AddNoticeRo
 * @Description TODO
 * @Date 2022/11/14 16:47
 */

@Data
public class AddNoticeRo {


    @NotBlank(message = "内容不能为空")
    /**
     * 帖子内容
     */
    @ApiModelProperty(value = "帖子内容")
    private String content;

    @NotNull(message = "类型不能为空")
    @ApiModelProperty("LEIXING ")
    private Type type;

}
