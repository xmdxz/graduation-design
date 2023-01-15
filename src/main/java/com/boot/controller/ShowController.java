package com.boot.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.boot.common.request.page.PageQuery;
import com.boot.common.request.page.PageResult;
import com.boot.common.response.Response;
import com.boot.common.response.ResponseUtil;
import com.boot.dto.Collect;
import com.boot.dto.Show;
import com.boot.dto.ShowListDto;
import com.boot.enums.Type;
import com.boot.exception.ServiceException;
import com.boot.service.CollectService;
import com.boot.service.ShowService;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.Objects;

/**
 * @class: ShowController
 * @author: liyusheng
 * @description:
 * @date: 2023/1/3 10:43
 */
@RestController
@RequestMapping("show")
public class ShowController {

    @Resource
    private ShowService showService;

    @Resource
    private CollectService collectService;

    @GetMapping("getShowList")
    @ApiOperation("获取演出列表")
    public Response<PageResult<Show>> getShowList(ShowListDto dto) {
        IPage<Show> page = PageQuery.getPage(dto);
        showService.page(page, Wrappers.lambdaQuery(Show.class).eq(StringUtils.isNotBlank(dto.getShowName()), Show::getName, dto.getShowName())
                .eq(StringUtils.isNotBlank(dto.getType()), Show::getType, dto.getType())
                .eq(StringUtils.isNotBlank(dto.getCity()), Show::getCity, dto.getCity())
                .orderByDesc(Show::getCreateTime));
        return ResponseUtil.success(PageResult.buildResult(page));
    }

    @GetMapping("getShowDetail")
    @ApiOperation("获取影片细节")
    public Response<Show> getShowDetail(String id) {
        return ResponseUtil.success(showService.getById(id));
    }

    @GetMapping("isCollectForShow")
    @ApiOperation("是否已经收藏")
    public Response<Boolean> isCollectForShow(String userId, String showId) {
        Collect one = collectService.getOne(Wrappers.lambdaQuery(Collect.class).eq(Collect::getUserId, userId)
                .eq(Collect::getTypeId, showId));
        return ResponseUtil.success(one == null ? Boolean.FALSE : Boolean.TRUE);
    }

    @PostMapping("collect")
    @ApiOperation("收藏")
    public Response<Boolean> collect(String userId, String showId) {
        Collect one = collectService.getOne(Wrappers.lambdaQuery(Collect.class)
                .eq(Collect::getTypeId, showId)
                .eq(Collect::getUserId, userId));
        if (!Objects.isNull(one)) {
            throw new ServiceException("当前电影已经被您收藏了哦");
        }
        return ResponseUtil.success(collectService.save(new Collect(showId, userId, Type.MOVIE)));
    }

    @PostMapping("cancelCollect")
    @ApiOperation("取消收藏")
    public Response<Boolean> cancelCollect(String userId, String showId) {
        boolean remove = collectService.remove(Wrappers.lambdaQuery(Collect.class)
                .eq(Collect::getTypeId, showId)
                .eq(Collect::getUserId, userId));
        return ResponseUtil.success(remove);
    }
}
