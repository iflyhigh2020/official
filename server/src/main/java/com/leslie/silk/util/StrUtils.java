package com.leslie.silk.util;

import java.util.UUID;

public class StrUtils {


  public static String genUUID() {

    String uuidStr = UUID.randomUUID().toString();

    return uuidStr.replaceAll("-", "");
  }
}
