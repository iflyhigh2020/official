package com.leslie.silk.entity;

import com.alibaba.fastjson.JSONObject;

public class UserThreadLocal {

  private static final ThreadLocal<JSONObject> LOCAL = new ThreadLocal();


  private UserThreadLocal(){

  }

  public static void set(JSONObject jsonObject){
    LOCAL.set(jsonObject);;
  }

  public static JSONObject get(){

    JSONObject loginInfo = LOCAL.get();
    if (null == loginInfo) {
      return new JSONObject();
    }
    return LOCAL.get();
  }


}
