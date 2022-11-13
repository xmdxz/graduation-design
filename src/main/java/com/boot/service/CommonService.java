package com.boot.service;

import com.boot.common.enums.Type;
import com.boot.dto.vo.CommentVo;
import com.boot.dto.vo.PublishPriceVo;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * @Author YuanXin
 * @ClassName CommonService
 * @Description TODO
 * @Date 2022/11/9 18:07
 */
public interface CommonService {
    String upload(MultipartFile file);

    List<CommentVo> comment(String id, Type type);

    List<PublishPriceVo> publishPrice(String id);
}
