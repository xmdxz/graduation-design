package com.boot.service;

import org.springframework.web.multipart.MultipartFile;


public interface CommonService {
    String upload(MultipartFile file);
}
