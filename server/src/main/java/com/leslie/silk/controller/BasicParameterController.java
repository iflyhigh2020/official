package com.leslie.silk.controller;

import com.leslie.silk.entity.ActionResult;
import com.leslie.silk.entity.BasicParameter;
import com.leslie.silk.service.BasicParameterService;
import javax.annotation.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * 参数表 前端控制器
 * </p>
 *
 * @author wangyong
 * @since 2019-07-04
 */
@RestController
@RequestMapping("/parameter")
//@CrossOrigin
//@ViewFolder("parameter")
public class BasicParameterController extends BasicController{

  @Autowired
  private BasicParameterService basicParameterService;
//  @ApiOperation(value = "查询退货申请列表")
  @RequestMapping(value="/getParam",method = RequestMethod.GET)
  public ActionResult getParam(int id){
    BasicParameter parameter = basicParameterService.getById(id);
    return actionResult(parameter);
  }

  private static final String CATEGORYS_PARAM = "CATEGORY_PARAM";

  @RequestMapping(value="/listByType",method = RequestMethod.GET)
  public ActionResult listByType(){
    return actionResult(basicParameterService.listByType(CATEGORYS_PARAM));
  }
}