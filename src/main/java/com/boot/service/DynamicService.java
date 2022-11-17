package com.boot.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.boot.common.request.page.PageResult;
import com.boot.dto.ro.PublishDynamicRo;
import com.boot.dto.vo.DynamicPageVo;

public interface DynamicService {
    PageResult<DynamicPageVo> page(IPage<DynamicPageVo> page, String userId, String keywords);

    Boolean publish(PublishDynamicRo ro);

    Boolean delete(String id);
}
