package com.leslie.silk.controller;

import com.leslie.silk.annotaion.LoginCheck;
import com.leslie.silk.entity.ActionResult;
import com.leslie.silk.entity.ImgText;
import com.leslie.silk.enums.ResultCode;
import com.leslie.silk.service.ImgTextService;
import lombok.extern.java.Log;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * (ImgText)表控制层
 *
 * @author makejava
 * @since 2020-04-26 14:57:07
 */
@RestController
@RequestMapping("imgText")
public class ImgTextController extends BasicController{
    /**
     * 服务对象
     */
    @Resource
    private ImgTextService imgTextService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("selectOne")
    public ImgText selectOne(Integer id) {
        return this.imgTextService.queryById(id);
    }

    @GetMapping("getByType")
    public ActionResult<ImgText> getByType(Integer pageType, Integer groupId) {
        return actionResult(imgTextService.getByType(pageType, groupId));
    }

    @GetMapping("getByType4Manager")
    @LoginCheck
    public ActionResult<ImgText> getByType4Manager(Integer pageType, Integer groupId) {
        return actionResult(imgTextService.getByType(pageType, groupId));
    }

    @PostMapping("save")
    @LoginCheck
    public ActionResult save(@RequestBody ImgText imgText) {
        imgTextService.insert(imgText);
        return actionResult(ResultCode.SUCCESS);
    }
}