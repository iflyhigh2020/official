package com.leslie.silk.controller;

import com.leslie.silk.annotaion.LoginCheck;
import com.leslie.silk.entity.ActionResult;
import com.leslie.silk.entity.Banner;
import com.leslie.silk.enums.ResultCode;
import com.leslie.silk.service.BannerService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * (Banner)表控制层
 *
 * @author makejava
 * @since 2020-04-26 17:01:38
 */
@RestController
@RequestMapping("banner")
public class BannerController extends BasicController {
    /**
     * 服务对象
     */
    @Resource
    private BannerService bannerService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("selectOne")
    public Banner selectOne(Integer id) {
        return this.bannerService.queryById(id);
    }

    @GetMapping("getByType")
    public ActionResult<Banner> getByType(Integer pageType, Integer groupId) {
        return actionResult(bannerService.getByType(pageType, groupId));
    }

    @GetMapping("getByType4Manager")
    @LoginCheck
    public ActionResult<Banner> getByType4Manager(Integer pageType, Integer groupId) {
        return actionResult(bannerService.getByType(pageType, groupId));
    }

    @PostMapping("save")
    @LoginCheck
    public ActionResult save(@RequestBody Banner banner) {
        bannerService.insert(banner);
        return actionResult(ResultCode.SUCCESS);
    }
}