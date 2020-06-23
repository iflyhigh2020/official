package com.leslie.silk.controller;

import com.leslie.silk.annotaion.LoginCheck;
import com.leslie.silk.entity.ActionResult;
import com.leslie.silk.entity.Footer;
import com.leslie.silk.enums.ResultCode;
import com.leslie.silk.service.FooterService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * 页面footer(Footer)表控制层
 *
 * @author makejava
 * @since 2020-04-29 17:09:00
 */
@RestController
@RequestMapping("footer")
public class FooterController extends BasicController{
    /**
     * 服务对象
     */
    @Resource
    private FooterService footerService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("selectOne")
    public Footer selectOne(Integer id) {
        return this.footerService.queryById(id);
    }

    /**
     * 通过主键查询单条数据
     *
     * @return 单条数据
     */
    @PostMapping("save")
    @LoginCheck
    public ActionResult save(@RequestBody Footer footer) {

        footerService.insert(footer);
        return actionResult(ResultCode.SUCCESS);
    }


    @GetMapping("getCurrentFooter")
    public ActionResult getCurrentFooter() {
        return actionResult(footerService.getCurrentFooter());
    }

}