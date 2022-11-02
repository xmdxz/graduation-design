package com.boot.common.dao;

import cn.hutool.http.HttpRequest;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

import javax.validation.constraints.NotBlank;

/**
 * 前端固定的上传文件格式
 *
 * @author YuanXin
 **/
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@TableName(autoResultMap = true)
@ToString
public class UploadFile {
    public interface UploadFileValidate {
    }

    private String fileName;
    @NotBlank(message = "文件上传错误", groups = {UploadFileValidate.class})
    @NotBlank(message = "文件上传错误")
    private String fileUrl;
    private String name;
    private String status;
    private String uid;
    private String url;
    @JsonIgnoreProperties
    private Byte[] bytes;

    public static byte[] getBytes(UploadFile file) {
        return HttpRequest.get(file.getFileUrl()).execute().bodyBytes();
    }

    public static byte[] getBytesByUrl(UploadFile file) {
        return HttpRequest.get(file.getUrl()).execute().bodyBytes();
    }
}
