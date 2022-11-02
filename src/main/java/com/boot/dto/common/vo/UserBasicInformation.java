package com.boot.dto.common.vo;

import com.boot.common.dao.UploadFile;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.experimental.Accessors;

/**
 * @Author YuanXin
 * @ClassName UserBasicInformation
 * @Description TODO
 * @Date 2022/9/11 16:10
 */

@Data
@Accessors(chain = true)
public class UserBasicInformation {

    @ApiModelProperty("id")
    private String id;

    @ApiModelProperty("用户名")
    private String username;

    @ApiModelProperty("头像")
    private UploadFile avatar;
}
