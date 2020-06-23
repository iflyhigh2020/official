package com.leslie.silk.controller.article;

import com.leslie.silk.annotaion.LoginCheck;
import com.leslie.silk.annotaion.RoleType;
import com.leslie.silk.controller.BasicController;
import com.leslie.silk.entity.ActionResult;
import com.leslie.silk.entity.article.ArticleCategory;
import com.leslie.silk.enums.ResultCode;
import com.leslie.silk.service.article.ArticleCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author wangyong
 */
@RestController
@RequestMapping("/category")
public class ArticleCategoryController extends BasicController {

  @Autowired
  private ArticleCategoryService articleCategoryService;

  @RequestMapping(value = "/list4Home", method = RequestMethod.GET)
  public ActionResult list4Home() {
    return actionResult(articleCategoryService.list4Home());
  }

  @RequestMapping(value = "/listAllCategory", method = RequestMethod.GET)
  public ActionResult listAllCategory() {
    return actionResult(articleCategoryService.listAllCategory());
  }

  @LoginCheck(roleType = RoleType.ADMIN)
  @RequestMapping(value = "/add", method = RequestMethod.POST)
  public ActionResult add(@RequestBody ArticleCategory category) {
    articleCategoryService.add(category);
    return actionResult(ResultCode.SUCCESS);
  }

  @LoginCheck(roleType = RoleType.ADMIN)
  @RequestMapping(value = "/update", method = RequestMethod.POST)
  public ActionResult update(@RequestBody ArticleCategory category) {
    articleCategoryService.update(category);
    return actionResult(ResultCode.SUCCESS);
  }

  @LoginCheck(roleType = RoleType.ADMIN)
  @RequestMapping(value = "/getById", method = RequestMethod.GET)
  public ActionResult getById(Integer id) {
    return actionResult(articleCategoryService.getById(id));
  }

}