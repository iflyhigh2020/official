package com.leslie.silk.annotaion;

public enum RoleType {

  ADMIN("管理员"),
  GENERAL_USER("普通用户");

  RoleType(String roleName) {
    this.roleName = roleName;
  }

  private String roleName;

  public String getRoleName() {
    return roleName;
  }

  public void setRoleName(String roleName) {
    this.roleName = roleName;
  }
}
