package com.boot.service.impl;

import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.text.CharSequenceUtil;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.boot.common.enums.Type;
import com.boot.common.exception.ServiceException;
import com.boot.common.request.page.PageResult;
import com.boot.dal.dao.CarouselChart;
import com.boot.dal.dao.Comment;
import com.boot.dal.dao.Notice;
import com.boot.dal.dao.PublishPrice;
import com.boot.dal.repository.CarouselChartRepository;
import com.boot.dal.repository.CommentRepository;
import com.boot.dal.repository.NoticeRepository;
import com.boot.dal.repository.PublishPriceRepository;
import com.boot.dto.ro.AddNoticeRo;
import com.boot.dto.vo.CarouselChartVo;
import com.boot.dto.vo.CommentVo;
import com.boot.dto.vo.NoticePageVo;
import com.boot.dto.vo.PublishPriceVo;
import com.boot.service.CommonService;
import com.boot.wrappers.CommentWrapper;
import com.boot.wrappers.PublishPriceWrapper;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;


@Service
@Log4j2
@AllArgsConstructor
public class CommonServiceImpl implements CommonService, ApplicationRunner {

    private static final String CLASS_PATH_STATIC = "/images";

    private final NoticeRepository noticeRepository;
    private static String CLASS_PATH_IMAGES_PATH;
    private final CommentRepository commentRepository;

    private final CarouselChartRepository carouselChartRepository;

    private final CommentWrapper commentWrapper;
    private final PublishPriceRepository publishPriceRepository;
    private final PublishPriceWrapper publishPriceWrapper;

    @Override
    public String upload(MultipartFile file) {
        String filename = file.getOriginalFilename();
        if (CharSequenceUtil.isBlank(filename)) {
            filename = ".jpg";
        }
        String ext = filename.substring(filename.lastIndexOf("."));
        String targetFileName = "/" + System.currentTimeMillis() + ext;
        File target = new File(CLASS_PATH_IMAGES_PATH + targetFileName);
        try {
            file.transferTo(target);
        } catch (IOException e) {
            throw new ServiceException("文件上传失败");
        }
        return CLASS_PATH_STATIC + targetFileName;
    }

    @Override
    public List<CommentVo> comment(String id, Type type) {
        List<Comment> comments = commentRepository.listById(id, Type.GOODS);
        List<CommentVo> commentVos = commentWrapper.toCommentListVo(comments);
        return commentVos;
    }

    @Override
    public List<PublishPriceVo> publishPrice(String id) {
        List<PublishPrice> publishPrices = publishPriceRepository.listById(id);
        return publishPriceWrapper.toVo(publishPrices);
    }

    @Override
    public Boolean deleteNotice(String id) {
        return noticeRepository.removeById(id);
    }

    @Override
    public PageResult<NoticePageVo> pageNotice(IPage<Notice> page, String keywords) {
        IPage<Notice> page1 = noticeRepository.page(page, Wrappers.<Notice>lambdaQuery()
                .like(CharSequenceUtil.isNotBlank(keywords), Notice::getContent, keywords)
                .orderByDesc(Notice::getCreateTime));
        List<NoticePageVo> result = commentWrapper.toNoticePageVo(page1.getRecords());
        return PageResult.buildResult(page1.getTotal(), result);
    }

    @Override
    public Boolean addNotice(AddNoticeRo ro) {
        Notice notice = new Notice();
        notice.setContent(ro.getContent());
        notice.setType(ro.getType());
        return noticeRepository.save(notice);
    }

    @Override
    public List<String> listNotice(Type type) {
        List<Notice> list = noticeRepository.list(Wrappers.<Notice>lambdaQuery()
                .eq(Notice::getType, type)
                .orderByDesc(Notice::getCreateTime));
        if (CollUtil.isNotEmpty(list)) {
            return list.stream().map(Notice::getContent).collect(Collectors.toList());
        }
        return Collections.emptyList();
    }

    @Override
    public List<CarouselChartVo> carous() {
        List<CarouselChart> list = carouselChartRepository.list(Wrappers.<CarouselChart>lambdaQuery()
                .orderByDesc(CarouselChart::getCreateTime));
        return commentWrapper.toChartVo(list);
    }

    @Override
    public Boolean addIndex(String image) {
        CarouselChart carouselChart = new CarouselChart();
        carouselChart.setImage(image);
        return carouselChartRepository.save(carouselChart);
    }

    @Override
    public Boolean deleteIndex(String id) {
        return carouselChartRepository.removeById(id);
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        try {
            CLASS_PATH_IMAGES_PATH = new ClassPathResource("static" + CLASS_PATH_STATIC).getFile().getAbsolutePath();
        } catch (IOException e) {
            log.error(e);
        }
    }
}
