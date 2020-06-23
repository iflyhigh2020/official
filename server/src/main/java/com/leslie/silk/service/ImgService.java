package com.leslie.silk.service;

import com.leslie.silk.config.AliyunOssConfig;
import com.leslie.silk.util.AliyunOssUtils;
import com.leslie.silk.util.StrUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;


@Service
@Transactional
public class ImgService {

    public String uploadArticleImg(MultipartFile file) throws Exception {
        StringBuilder imgUrl = new StringBuilder();
        String ossFilePrefix = StrUtils.genUUID();
        String ossFileName = ossFilePrefix + file.getOriginalFilename()
                .substring(file.getOriginalFilename().lastIndexOf("."));
        String fileName = new String(file.getOriginalFilename().getBytes("utf-8"));
        AliyunOssUtils.uploadFile(file, ossFileName);
        imgUrl.append("http://").append(AliyunOssConfig.getDefaultBucketName()).append(".")
                .append(AliyunOssConfig.getEndpointContent()).append("/")
                .append(ossFileName);
        return imgUrl.toString();
    }
}
