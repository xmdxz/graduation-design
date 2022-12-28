package com.boot.controller;

import com.boot.common.response.Response;
import com.boot.common.response.ResponseUtil;
import com.boot.service.CommonService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;


@RestController
@Api(tags = "通用")
@AllArgsConstructor
public class CommonController {

    private final CommonService commonService;


    @PostMapping("/upload")
    @ApiOperation("文件上传-固定模板写法")
    public Response<String> upload(MultipartFile file) {
        return ResponseUtil.success(commonService.upload(file));
    }

}