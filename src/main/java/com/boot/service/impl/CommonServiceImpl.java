package com.boot.service.impl;

import cn.hutool.core.text.CharSequenceUtil;
import com.boot.common.exception.ServiceException;
import com.boot.service.CommonService;
import lombok.extern.log4j.Log4j2;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

/**
 * @Author YuanXin
 * @ClassName CommonServiceImpl
 * @Description TODO
 * @Date 2022/11/9 18:10
 */
@Service
@Log4j2
public class CommonServiceImpl implements CommonService {

    private static final String CLASS_PATH_STATIC = "/images";
    private static String CLASS_PATH_IMAGES_PATH;

    static {
        try {
            CLASS_PATH_IMAGES_PATH = new ClassPathResource("static" + CLASS_PATH_STATIC).getFile().getAbsolutePath();
        } catch (IOException e) {
            log.error(e);
        }
    }

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
}
