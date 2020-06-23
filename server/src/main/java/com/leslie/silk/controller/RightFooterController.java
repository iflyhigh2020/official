package com.leslie.silk.controller;

import com.leslie.silk.annotaion.LoginCheck;
import com.leslie.silk.entity.ActionResult;
import com.leslie.silk.entity.RightFooter;
import com.leslie.silk.enums.ResultCode;
import com.leslie.silk.service.RightFooterService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * 右侧固定悬浮栏(RightFooter)表控制层
 *
 * @author makejava
 * @since 2020-05-07 11:18:20
 */
@RestController
@RequestMapping("rightFooter")
public class RightFooterController extends BasicController{
    /**
     * 服务对象
     */
    @Resource
    private RightFooterService rightFooterService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("selectOne")
    public RightFooter selectOne(Integer id) {
        return this.rightFooterService.queryById(id);
    }

    @GetMapping("getCurrent")
    public ActionResult getCurrent() {
        return actionResult(rightFooterService.getCurrent());
    }


    @PostMapping("save")
    @LoginCheck
    public ActionResult save(@RequestBody RightFooter rightFooter) {
        rightFooterService.insert(rightFooter);
        return actionResult(ResultCode.SUCCESS);
    }
}