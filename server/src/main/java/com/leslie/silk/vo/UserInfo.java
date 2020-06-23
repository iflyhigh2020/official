package com.leslie.silk.vo;

public class UserInfo {

  private Integer id;

  private String nickname;

  private String username;

  private String phone;

  private String email;

  private String address;

  private String adminFlag;

  public String getPhone() {
    return phone;
  }

  public void setPhone(String phone) {
    this.phone = phone;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getAddress() {
    return address;
  }

  public void setAddress(String address) {
    this.address = address;
  }

  public String getAdminFlag() {
    return adminFlag;
  }

  public void setAdminFlag(String adminFlag) {
    this.adminFlag = adminFlag;
  }

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getNickname() {
    return nickname;
  }

  public void setNickname(String nickname) {
    this.nickname = nickname;
  }

  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
  }
}
