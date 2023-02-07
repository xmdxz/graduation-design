package com.boot.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.boot.common.request.page.PageQuery;
import com.boot.common.request.page.PageResult;
import com.boot.common.response.Response;
import com.boot.common.response.ResponseUtil;
import com.boot.dto.City;
import com.boot.dto.CityDto;
import com.boot.service.CityService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * @class: CityController
 * @author: liyusheng
 * @description:
 * @date: 2022/12/28 14:05
 */
@RestController
@RequestMapping("city")
public class CityController {
    @Resource
    private CityService cityService;

    @GetMapping("getCity")
    public Response<List<City>> getHotCity() {
        List<City> list = cityService.list(Wrappers.lambdaQuery(City.class).orderByAsc(City::getCityCode));
        return ResponseUtil.success(list);
    }

    @GetMapping("getCityForManage")
    public Response<PageResult<City>> getCityForManage(CityDto dto) {
        IPage<City> page = PageQuery.getPage(dto);
        cityService.page(page, Wrappers.lambdaQuery(City.class).eq(StringUtils.isNotBlank(dto.getCityName()), City::getCityName, dto.getCityName()).orderByAsc(City::getCityCode));
        return ResponseUtil.success(PageResult.buildResult(page));
    }

    @PostMapping("addCity")
    public Response<Boolean> addCity(@RequestBody City city) {
        city.setIsDeleted(0);
        cityService.saveOrUpdate(city);
        return ResponseUtil.success(Boolean.TRUE);
    }

    @GetMapping("deleteCity")
    public Response<Boolean> deleteCity(String id) {
        return ResponseUtil.success(cityService.removeById(id));
    }
}
