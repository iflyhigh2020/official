package com.leslie.silk.controller;

import com.leslie.silk.annotaion.LoginCheck;
import com.leslie.silk.entity.ActionResult;
import com.leslie.silk.entity.SlidesInfo;
import com.leslie.silk.enums.ResultCode;
import com.leslie.silk.service.SlidesInfoService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * (SlidesInfo)表控制层
 *
 * @author makejava
 * @since 2020-05-15 14:08:48
 */
@RestController
@RequestMapping("slidesInfo")
public class SlidesInfoController extends BasicController{
    /**
     * 服务对象
     */
    @Resource
    private SlidesInfoService slidesInfoService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("selectOne")
    public SlidesInfo selectOne(Integer id) {
        return this.slidesInfoService.queryById(id);
    }


    @GetMapping("getSlidesInfo")
    public ActionResult getSlidesInfo(Integer pageType, Integer groupId) {
        return actionResult(slidesInfoService.getByType(pageType, groupId));
    }

    @PostMapping("save")
    @LoginCheck
    public ActionResult save(@RequestBody SlidesInfo slidesInfo) {
        slidesInfoService.insert(slidesInfo);
        return actionResult(ResultCode.SUCCESS);
    }
}