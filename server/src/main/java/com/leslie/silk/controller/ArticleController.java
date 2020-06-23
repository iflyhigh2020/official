package com.leslie.silk.controller;

import com.leslie.silk.entity.ActionResult;
import com.leslie.silk.entity.Article;
import com.leslie.silk.enums.ResultCode;
import com.leslie.silk.service.ArticleService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * 文章表(Article)表控制层
 *
 * @author makejava
 * @since 2020-05-19 15:12:25
 */
@RestController
@RequestMapping("article")
public class ArticleController extends BasicController{
    /**
     * 服务对象
     */
    @Resource
    private ArticleService articleService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("selectOne")
    public Article selectOne(Integer id) {
        return this.articleService.queryById(id);
    }

    @GetMapping("getByType")
    public ActionResult<Article> getByType(Integer pageType, Integer groupId) {
        return actionResult(articleService.getByType(pageType, groupId));
    }

    @PostMapping("save")
    public ActionResult save(@RequestBody Article article) {
        articleService.insert(article);
        return actionResult(ResultCode.SUCCESS);
    }

}