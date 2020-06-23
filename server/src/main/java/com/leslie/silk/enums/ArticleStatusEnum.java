package com.leslie.silk.enums;


public enum ArticleStatusEnum {

  DRAFT(1, "草稿", false),
  WAIT_AUDIT(2, "待审核", true),
  AUDIT_PASS(3, "审核通过", false),
  RETURN_UPDATE(4, "返回修改", false),
  REJECT(5, "审核拒绝", false);

  private Integer status;

  private String statusDesc;

  private boolean canAudit;

  public static String getDescByStatus(Integer status) {
    if (null == status) {
      return "";
    }
    for (ArticleStatusEnum statusEnum : ArticleStatusEnum.values()) {
      if (status.equals(statusEnum.getStatus())) {
        return statusEnum.getStatusDesc();
      }
    }
    return "";
  }

  ArticleStatusEnum(Integer status, String statusDesc, boolean canAudit) {
    this.status = status;
    this.statusDesc = statusDesc;
    this.canAudit = canAudit;
  }

  public boolean isCanAudit() {
    return canAudit;
  }

  public void setCanAudit(boolean canAudit) {
    this.canAudit = canAudit;
  }

  public static ArticleStatusEnum getByStatus(Integer status) {
    for (ArticleStatusEnum statusEnum : ArticleStatusEnum.values()) {
      if (statusEnum.getStatus().equals(status)) {
        return statusEnum;
      }
    }
    return null;
  }

  public Integer getStatus() {
    return status;
  }

  public void setStatus(Integer status) {
    this.status = status;
  }

  public String getStatusDesc() {
    return statusDesc;
  }

  public void setStatusDesc(String statusDesc) {
    this.statusDesc = statusDesc;
  }
}
