package com.leslie.silk.controller;

import com.leslie.silk.annotaion.LoginCheck;
import com.leslie.silk.entity.ActionResult;
import com.leslie.silk.enums.ResultCode;
import com.leslie.silk.service.ImgService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.servlet.http.HttpServletRequest;

/**
 * @author wangyong
 */
@RestController
@RequestMapping("/img")
public class ImgController extends BasicController{


    @Autowired
    private ImgService imgService;

//    @LoginCheck
    @ResponseBody
    @RequestMapping(value="/imgUpload",method = RequestMethod.POST)
    public ActionResult imgUpload(HttpServletRequest request)  {
        try {
            MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;
            MultipartFile multipartFile = multipartRequest.getFile(multipartRequest.getFileNames().next());
            String address = imgService.uploadArticleImg(multipartFile);
            System.out.println(address);
            return actionResult(address);
        } catch (Exception e) {
            return actionResult(ResultCode.FAILURE, e.getMessage());
        }
    }

}
