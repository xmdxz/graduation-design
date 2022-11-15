package com.boot.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.boot.common.request.page.PageResult;
import com.boot.dal.dao.Dynamic;
import com.boot.dal.repository.DynamicRepository;
import com.boot.dal.repository.UserRepository;
import com.boot.dto.common.vo.UserBasicInformation;
import com.boot.dto.ro.PublishDynamicRo;
import com.boot.dto.vo.DynamicPageVo;
import com.boot.service.DynamicService;
import com.boot.wrappers.DynamicWrapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * @Author YuanXin
 * @ClassName DynamicServiceImpl
 * @Description TODO
 * @Date 2022/11/13 15:54
 */

@Service
@AllArgsConstructor
public class DynamicServiceImpl implements DynamicService {

    private final DynamicRepository dynamicRepository;

    private final DynamicWrapper dynamicWrapper;

    private final UserRepository userRepository;

    @Override
    public PageResult<DynamicPageVo> page(IPage<DynamicPageVo> page, String userId, String keywords) {
        IPage<DynamicPageVo> dynamicPageVoIPage = dynamicRepository.listPage(page, userId, keywords);
        return PageResult.buildResult(dynamicPageVoIPage);
    }

    @Override
    public Boolean publish(PublishDynamicRo ro) {
        UserBasicInformation userBasic = userRepository.getUserBasic(ro.getUserId());
        Dynamic dynamic = new Dynamic();
        dynamic.setContent(ro.getContent());
        dynamic.setUserId(userBasic.getId());
        dynamic.setImages(ro.getImages());
        return dynamicRepository.save(dynamic);
    }

    @Override
    public Boolean delete(String id) {
        return dynamicRepository.removeById(id);
    }
}
