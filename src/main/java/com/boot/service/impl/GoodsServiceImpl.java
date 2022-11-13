package com.boot.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.boot.common.enums.GoodsStatus;
import com.boot.common.enums.Type;
import com.boot.common.request.page.PageResult;
import com.boot.dal.dao.Comment;
import com.boot.dal.dao.Goods;
import com.boot.dal.dao.PublishPrice;
import com.boot.dal.repository.CommentRepository;
import com.boot.dal.repository.GoodsRepository;
import com.boot.dal.repository.PublishPriceRepository;
import com.boot.dal.repository.UserRepository;
import com.boot.dto.common.vo.UserBasicInformation;
import com.boot.dto.ro.PublishGoodsRo;
import com.boot.dto.vo.CommentVo;
import com.boot.dto.vo.GoodsDetailVo;
import com.boot.dto.vo.GoodsPageVo;
import com.boot.service.GoodsService;
import com.boot.wrappers.CommentWrapper;
import com.boot.wrappers.GoodsWrapper;
import com.boot.wrappers.PublishPriceWrapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author YuanXin
 * @ClassName GoodsServiceImpl
 * @Description TODO
 * @Date 2022/11/12 16:00
 */
@Service
@AllArgsConstructor
public class GoodsServiceImpl implements GoodsService {

    private final GoodsRepository goodsRepository;

    private final GoodsWrapper goodsWrapper;

    private final CommentRepository commentRepository;

    private final CommentWrapper commentWrapper;

    private final PublishPriceRepository publishPriceRepository;

    private final UserRepository userRepository;
    private final PublishPriceWrapper publishPriceWrapper;


    @Override
    public PageResult<GoodsPageVo> page(IPage<Goods> page) {
        IPage<Goods> goodsIPage = goodsRepository.pageOwn(page, null);
        List<GoodsPageVo> res = goodsWrapper.toPageVo(goodsIPage.getRecords());
        return PageResult.buildResult(goodsIPage.getTotal(), res);
    }

    @Override
    public GoodsDetailVo detail(String id) {
        Goods goods = goodsRepository.getById(id);
        GoodsDetailVo goodsDetailVo = goodsWrapper.toDetail(goods);
        goodsDetailVo.setUserInfo(userRepository.getUserBasic(goods.getUserId()));
        List<Comment> comments = commentRepository.listById(goods.getId(), Type.GOODS);
        List<CommentVo> commentVos = commentWrapper.toCommentListVo(comments);
        goodsDetailVo.setComments(commentVos);
        List<PublishPrice> publishPrices = publishPriceRepository.listById(goods.getId());
        goodsDetailVo.setPublishPrice(publishPriceWrapper.toVo(publishPrices));
        return goodsDetailVo;
    }

    @Override
    public Boolean publish(PublishGoodsRo ro) {
        UserBasicInformation userBasic = userRepository.getUserBasic(ro.getUserId());
        Goods goods = new Goods();
        goods.setContent(ro.getContent());
        goods.setStatus(GoodsStatus.NORMAL);
        goods.setImages(ro.getImages());
        goods.setName(ro.getName());
        goods.setUserId(userBasic.getId());
        goods.setPrice(ro.getPrice());
        return goodsRepository.save(goods);
    }
}
