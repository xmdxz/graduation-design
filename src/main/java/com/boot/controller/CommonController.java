package com.boot.controller;

import com.boot.common.enums.Type;
import com.boot.common.request.page.PageQuery;
import com.boot.common.request.page.PageResult;
import com.boot.common.response.Response;
import com.boot.common.response.ResponseUtil;
import com.boot.dto.ro.AddNoticeRo;
import com.boot.dto.vo.CarouselChartVo;
import com.boot.dto.vo.CommentVo;
import com.boot.dto.vo.NoticePageVo;
import com.boot.dto.vo.PublishPriceVo;
import com.boot.service.CommonService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;


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


    @GetMapping("/comment")
    @ApiOperation("获取评论")
    public Response<List<CommentVo>> comments(String id, Type type) {
        return ResponseUtil.success(commonService.comment(id, type));
    }

    @GetMapping("/publishPrice")
    @ApiOperation("发布出价")
    public Response<List<PublishPriceVo>> publishPrice(String id) {
        return ResponseUtil.success(commonService.publishPrice(id));
    }


    @GetMapping("/notice/page")
    @ApiOperation("通知")
    public Response<PageResult<NoticePageVo>> pageNotice(PageQuery page, String keywords) {
        return ResponseUtil.success(commonService.pageNotice(PageQuery.getPage(page), keywords));
    }


    @PostMapping("/notice/add")
    @ApiOperation("添加通知")
    public Response<Boolean> addNotice(@RequestBody @Validated AddNoticeRo ro) {
        return ResponseUtil.success(commonService.addNotice(ro));
    }


    @GetMapping("/notice/delete")
    @ApiOperation("删除通知")
    public Response<Boolean> addNotice(String id) {
        return ResponseUtil.success(commonService.deleteNotice(id));
    }

    @GetMapping("/notice/list")
    @ApiOperation("获取通知")
    public Response<List<String>> listNotice(Type type) {
        return ResponseUtil.success(commonService.listNotice(type));
    }

    @GetMapping("/index/images")
    @ApiOperation("首页轮播图")
    public Response<List<CarouselChartVo>> carous() {
        return ResponseUtil.success(commonService.carous());
    }

    @GetMapping("/index/add")
    @ApiOperation("添加轮播图")
    public Response<Boolean> adIndex(String image) {
        return ResponseUtil.success(commonService.addIndex(image));
    }

    @GetMapping("/index/delete")
    @ApiOperation("删除轮播图")
    public Response<Boolean> deleteIndex(String id) {
        return ResponseUtil.success(commonService.deleteIndex(id));
    }

}
