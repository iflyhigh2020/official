package com.leslie.silk.controller;

import com.leslie.silk.annotaion.LoginCheck;
import com.leslie.silk.entity.ActionResult;
import com.leslie.silk.entity.Logo;
import com.leslie.silk.enums.ResultCode;
import com.leslie.silk.service.LogoService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * logo信息表(Logo)表控制层
 *
 * @author makejava
 * @since 2020-05-07 12:35:10
 */
@RestController
@RequestMapping("logo")
public class LogoController extends BasicController{
    /**
     * 服务对象
     */
    @Resource
    private LogoService logoService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("selectOne")
    public Logo selectOne(Integer id) {
        return this.logoService.queryById(id);
    }

    /**
     * 通过主键查询单条数据
     *
     * @return 单条数据
     */
    @GetMapping("getCurrent")
    public ActionResult getCurrent() {
        return actionResult(logoService.getCurrent());
    }

    /**
     * 通过主键查询单条数据
     *
     * @return 单条数据
     */
    @PostMapping("save")
    @LoginCheck
    public ActionResult save(@RequestBody Logo logo) {
        logoService.insert(logo);
        return actionResult(ResultCode.SUCCESS);
    }
}