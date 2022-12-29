package com.boot.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.boot.common.request.page.PageResult;
import com.boot.dao.FeedbackMapper;
import com.boot.dto.FeedBackVo;
import com.boot.service.BackService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * @Author YuanXin
 * @ClassName BackServiceImpl
 * @Description TODO
 * @Date 2022/12/29 10:20
 */

@Service
@AllArgsConstructor
public class BackServiceImpl implements BackService {

    private final FeedbackMapper feedbackMapper;

    @Override
    public PageResult<FeedBackVo> feedBackPage(IPage<Object> page) {
        IPage<FeedBackVo> ipage = feedbackMapper.page(page);
        return PageResult.buildResult(ipage);
    }
}
