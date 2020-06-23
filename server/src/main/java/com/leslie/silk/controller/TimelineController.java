package com.leslie.silk.controller;

import com.leslie.silk.annotaion.LoginCheck;
import com.leslie.silk.entity.ActionResult;
import com.leslie.silk.entity.ListShow;
import com.leslie.silk.entity.Timeline;
import com.leslie.silk.enums.ResultCode;
import com.leslie.silk.service.TimelineService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * (Timeline)表控制层
 *
 * @author makejava
 * @since 2020-04-27 09:42:32
 */
@RestController
@RequestMapping("timeline")
public class TimelineController extends BasicController {
    /**
     * 服务对象
     */
    @Resource
    private TimelineService timelineService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("selectOne")
    public Timeline selectOne(Integer id) {
        return this.timelineService.queryById(id);
    }

    @GetMapping("getByType")
    public ActionResult getByType(Integer pageType, Integer groupId) {
        return actionResult(timelineService.getByType(pageType, groupId));
    }

    @PostMapping("save")
    @LoginCheck
    public ActionResult save(@RequestBody Timeline timeline) {
        try {
            timelineService.insert(timeline);
        } catch (Exception e) {
            actionResult(ResultCode.FAILURE, e.getMessage());
        }
        return actionResult(ResultCode.SUCCESS);
    }

    @GetMapping("getByType4Manager")
    @LoginCheck
    public ActionResult getByType4Manager(Integer pageType, Integer groupId) {
        return actionResult(timelineService.getByType(pageType, groupId));
    }


}