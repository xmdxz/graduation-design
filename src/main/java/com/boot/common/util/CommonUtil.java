package com.boot.common.util;

import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.text.CharSequenceUtil;
import com.boot.common.dao.UploadFile;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @Author YuanXin
 * @ClassName CommonUtil
 * @Description TODO
 * @Date 2022/9/15 16:52
 */
public class CommonUtil {

    public static UploadFile getUploadFile(String url) {
        if (CharSequenceUtil.isBlank(url)) {
            return null;
        }
        UploadFile res = new UploadFile();
        res.setFileUrl(url);
        res.setUrl(url);
        return res;
    }

    public static List<UploadFile> getUploadFiles(List<String> urls) {
        if (CollUtil.isEmpty(urls)) {
            return null;
        }
        return urls.stream().map(CommonUtil::getUploadFile).collect(Collectors.toList());
    }

}
