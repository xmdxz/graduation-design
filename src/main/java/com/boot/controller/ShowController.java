package com.boot.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.boot.common.request.page.PageQuery;
import com.boot.common.request.page.PageResult;
import com.boot.common.response.Response;
import com.boot.common.response.ResponseUtil;
import com.boot.dto.Show;
import com.boot.dto.ShowListDto;
import com.boot.service.ShowService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

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

    @GetMapping("getShowList")
    public Response<PageResult<Show>> getShowList(ShowListDto dto) {
        IPage<Show> page = PageQuery.getPage(dto);
        showService.page(page, Wrappers.lambdaQuery(Show.class).eq(StringUtils.isNotBlank(dto.getShowName()), Show::getName, dto.getShowName())
                .eq(StringUtils.isNotBlank(dto.getType()), Show::getType, dto.getType())
                .eq(StringUtils.isNotBlank(dto.getCity()), Show::getCity, dto.getCity())
                .orderByDesc(Show::getCreateTime));
        return ResponseUtil.success(PageResult.buildResult(page));
    }

}
