package com.leslie.silk.interceptor;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.leslie.silk.annotaion.LoginCheck;
import com.leslie.silk.annotaion.RoleType;
import com.leslie.silk.entity.ActionResult;
import com.leslie.silk.entity.UserThreadLocal;
import com.leslie.silk.enums.ResultCode;
import com.leslie.silk.service.UserService;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@Component
public class LoginInterceptor implements HandlerInterceptor {

  @Resource
  private UserService userService;

  @Override
  public boolean preHandle(HttpServletRequest request,
      HttpServletResponse response, Object handler) throws IOException {

    //如果不是controller中 @RequestMapping注解的方法则直接通过
    if (!handler.getClass().isAssignableFrom(HandlerMethod.class)) {
      return true;
    }
    HandlerMethod method = (HandlerMethod)handler;
    // 方法未加注解直接通过
    LoginCheck loginCheck = method.getMethodAnnotation(LoginCheck.class);
    if (null == loginCheck){
      return true;
    }

    PrintWriter writer = null;
    String token = request.getHeader("token");
    try {
      if (!userService.check(token)) {
        writer = response.getWriter();
        writer.print(getResult(ResultCode.LOGIN_FAILURE.getCode(), "Auth Failure!", null));
      }
    } catch (Exception e) {
      writer = response.getWriter();
      writer.print(getResult(ResultCode.LOGIN_FAILURE.getCode(), "Auth Failure（Exception）!", null));
      return false;
    } finally {
      if (null != writer) {
        writer.close();
      }
    }
    return true;
  }

  private String getResult(int code, String errorInfo, String val) {
    return JSON.toJSONString(new ActionResult(code, errorInfo, val));
  }

  @Override
  public void postHandle(HttpServletRequest httpServletRequest,
      HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView)
      throws Exception {

  }

  //    在请求处理之后,视图渲染之前执行
  @Override
  public void afterCompletion(HttpServletRequest httpServletRequest,
      HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {

  }

}
