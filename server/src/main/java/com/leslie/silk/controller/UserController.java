package com.leslie.silk.controller;

import com.leslie.silk.annotaion.LoginCheck;
import com.leslie.silk.entity.ActionResult;
import com.leslie.silk.entity.User;
import com.leslie.silk.enums.ResultCode;
import com.leslie.silk.service.UserService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * 用户表(User)表控制层
 *
 * @author makejava
 * @since 2020-04-29 13:55:42
 */
@RestController
@RequestMapping("user")
public class UserController extends BasicController {
    /**
     * 服务对象
     */
    @Resource
    private UserService userService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("selectOne")
    @LoginCheck
    public User selectOne(Integer id) {
        return this.userService.queryById(id);
    }

    @PostMapping("login")
    public ActionResult<String> login(@RequestBody User user) {
        try {
            return actionResult(userService.login(user));
        } catch (Exception e) {
            return actionResult(ResultCode.FAILURE, e.getMessage());
        }
    }

    @PostMapping("modifyPwd")
    @LoginCheck
    public ActionResult modifyPwd(@RequestBody User user) {
        try {
            userService.modifyPwd(user);
            return actionResult(ResultCode.SUCCESS);
        } catch (Exception e) {
            return actionResult(ResultCode.FAILURE, e.getMessage());
        }
    }


}