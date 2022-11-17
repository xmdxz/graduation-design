package com.boot.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.boot.common.enums.Type;
import com.boot.common.request.page.PageResult;
import com.boot.dal.dao.Notice;
import com.boot.dto.ro.AddNoticeRo;
import com.boot.dto.vo.CarouselChartVo;
import com.boot.dto.vo.CommentVo;
import com.boot.dto.vo.NoticePageVo;
import com.boot.dto.vo.PublishPriceVo;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;


public interface CommonService {
    String upload(MultipartFile file);

    List<CommentVo> comment(String id, Type type);

    List<PublishPriceVo> publishPrice(String id);

    Boolean deleteNotice(String id);

    PageResult<NoticePageVo> pageNotice(IPage<Notice> page, String keywords);

    Boolean addNotice(AddNoticeRo ro);

    List<String> listNotice(Type type);

    List<CarouselChartVo> carous();

    Boolean addIndex(String image);

    Boolean deleteIndex(String id);
}
