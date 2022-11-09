package com.boot.service;

import org.springframework.web.multipart.MultipartFile;

/**
 * @Author YuanXin
 * @ClassName CommonService
 * @Description TODO
 * @Date 2022/11/9 18:07
 */
public interface CommonService {
    String upload(MultipartFile file);
}
