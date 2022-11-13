package com.boot.controller;

import com.boot.common.enums.Type;
import com.boot.common.response.Response;
import com.boot.common.response.ResponseUtil;
import com.boot.dto.vo.CommentVo;
import com.boot.dto.vo.PublishPriceVo;
import com.boot.service.CommonService;
import io.swagger.annotations.Api;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * @Author YuanXin
 * @ClassName CommonController
 * @Description TODO
 * @Date 2022/9/17 11:20
 */
@RestController
@Api(tags = "通用")
@AllArgsConstructor
public class CommonController {

    private final CommonService commonService;


    @PostMapping("/upload")
    public Response<String> upload(MultipartFile file) {
        return ResponseUtil.success(commonService.upload(file));
    }


    @GetMapping("/comment")
    public Response<List<CommentVo>> comments(String id, Type type) {
        return ResponseUtil.success(commonService.comment(id, type));
    }

    @GetMapping("/publishPrice")
    public Response<List<PublishPriceVo>> publishPrice(String id) {
        return ResponseUtil.success(commonService.publishPrice(id));
    }
}
