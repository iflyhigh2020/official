package com.leslie.silk.controller;

import com.leslie.silk.annotaion.LoginCheck;
import com.leslie.silk.entity.ActionResult;
import com.leslie.silk.entity.Sildes;
import com.leslie.silk.enums.ResultCode;
import com.leslie.silk.service.SildesService;
import com.leslie.silk.vo.SearchCommonVO;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * (Sildes)表控制层
 *
 * @author makejava
 * @since 2020-04-26 09:48:32
 */
@RestController
@RequestMapping("slides")
public class SildesController extends BasicController{

    /**
     * 服务对象
     */
    @Resource
    private SildesService sildesService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("selectOne")
    public Sildes selectOne(Integer id) {
        return this.sildesService.queryById(id);
    }

    @PostMapping("save")
    @LoginCheck
    public ActionResult save(@RequestBody Sildes sildes) {
        sildesService.insert(sildes);
        return actionResult(ResultCode.SUCCESS);
    }

    @PostMapping("update")
    @LoginCheck
    public ActionResult update(@RequestBody Sildes sildes) {
        sildesService.update(sildes);
        return actionResult(ResultCode.SUCCESS);
    }

    @GetMapping("delete")
    @LoginCheck
    public ActionResult delete(Integer id) {
        return actionResult(sildesService.deleteById(id));
    }


    @GetMapping("listSlides")
    public ActionResult listSlides(Integer pageType, Integer groupId) {
        return actionResult(sildesService.listSildes(pageType, groupId));
    }

    @GetMapping("listSlides4Manager")
    @LoginCheck
    public ActionResult listSlides4Manager(Integer pageType, Integer groupId) {
        return actionResult(sildesService.listSildes(pageType, groupId));
    }

    @PostMapping("list")
    public ActionResult list(@RequestBody SearchCommonVO<Sildes> condition)throws Exception {
        return actionResult(sildesService.list(condition));
    }

    @PostMapping("list4Manager")
    @LoginCheck
    public ActionResult list4Manager(@RequestBody SearchCommonVO<Sildes> condition)throws Exception {
        return actionResult(sildesService.list(condition));
    }
}