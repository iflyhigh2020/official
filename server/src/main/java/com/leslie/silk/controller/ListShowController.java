package com.leslie.silk.controller;


import com.leslie.silk.annotaion.LoginCheck;
import com.leslie.silk.entity.ActionResult;
import com.leslie.silk.entity.ListShow;
import com.leslie.silk.entity.Sildes;
import com.leslie.silk.enums.ResultCode;
import com.leslie.silk.service.ListShowService;
import com.leslie.silk.vo.SearchCommonVO;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * (ListShow)表控制层
 *
 * @author makejava
 * @since 2020-04-26 14:00:21
 */
@RestController
@RequestMapping("listShow")
public class ListShowController extends BasicController{
    /**
     * 服务对象
     */
    @Resource
    private ListShowService listShowService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("selectOne")
    public ActionResult selectOne(Integer id) {
        return actionResult(listShowService.queryById(id));
    }


    @GetMapping("listShows")
    public ActionResult listShows(Integer pageType, Integer groupId) {
        return actionResult(listShowService.listShows(pageType, groupId));
    }

    @GetMapping("listShows4Manager")
    @LoginCheck
    public ActionResult listShows4Manager(Integer pageType, Integer groupId) {
        return actionResult(listShowService.listShows(pageType, groupId));
    }

    @PostMapping("save")
    @LoginCheck
    public ActionResult save(@RequestBody ListShow listShow) {
        listShowService.insert(listShow);
        return actionResult(ResultCode.SUCCESS);
    }

    @PostMapping("update")
    @LoginCheck
    public ActionResult update(@RequestBody ListShow listShow) {
        listShowService.update(listShow);
        return actionResult(ResultCode.SUCCESS);
    }

    @GetMapping("delete")
    @LoginCheck
    public ActionResult delete(Integer id) {
        return actionResult(listShowService.deleteById(id));
    }

    @PostMapping("list")
    public ActionResult list(@RequestBody SearchCommonVO<ListShow> condition)throws Exception {

        return actionResult(listShowService.list(condition));
    }

    @PostMapping("list4Manager")
    @LoginCheck
    public ActionResult list4Manager(@RequestBody SearchCommonVO<ListShow> condition)throws Exception {

        return actionResult(listShowService.list(condition));
    }
}