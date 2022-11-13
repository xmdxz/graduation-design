package com.boot.service.impl;

import cn.hutool.core.text.CharSequenceUtil;
import com.boot.common.enums.Type;
import com.boot.common.exception.ServiceException;
import com.boot.dal.dao.Comment;
import com.boot.dal.dao.PublishPrice;
import com.boot.dal.repository.CommentRepository;
import com.boot.dal.repository.PublishPriceRepository;
import com.boot.dto.vo.CommentVo;
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
import java.util.List;

/**
 * @Author YuanXin
 * @ClassName CommonServiceImpl
 * @Description TODO
 * @Date 2022/11/9 18:10
 */
@Service
@Log4j2
@AllArgsConstructor
public class CommonServiceImpl implements CommonService, ApplicationRunner {

    private static final String CLASS_PATH_STATIC = "/images";
    private static String CLASS_PATH_IMAGES_PATH;
    private final CommentRepository commentRepository;

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
    public void run(ApplicationArguments args) throws Exception {
        try {
            CLASS_PATH_IMAGES_PATH = new ClassPathResource("static" + CLASS_PATH_STATIC).getFile().getAbsolutePath();
        } catch (IOException e) {
            log.error(e);
        }
    }
}
