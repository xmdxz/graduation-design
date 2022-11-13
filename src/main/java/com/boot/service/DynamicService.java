package com.boot.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.boot.common.request.page.PageResult;
import com.boot.dto.ro.PublishDynamicRo;
import com.boot.dto.vo.DynamicPageVo;

/**
 * @Author YuanXin
 * @ClassName DynamicService
 * @Description TODO
 * @Date 2022/11/13 15:47
 */
public interface DynamicService {
    PageResult<DynamicPageVo> page(IPage<DynamicPageVo> page, String userId);

    Boolean publish(PublishDynamicRo ro);
}
