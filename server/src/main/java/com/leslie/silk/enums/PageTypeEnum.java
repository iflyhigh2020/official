package com.leslie.silk.enums;

public enum PageTypeEnum {

    HOME_PAGE(1, "首页"),
    COSMETIC(2, "化妆品"),
    MEDICAL(3, "医用耗材"),
    SANITARY(4, "卫生巾用品"),
    SILK(5, "蚕丝无纺布"),
    ABOUT_US(6, "关于我们");

    PageTypeEnum(Integer pageType, String pageDesc) {
        this.pageType = pageType;
        this.pageDesc = pageDesc;
    }

    private Integer pageType;

    private String pageDesc;

    public Integer getPageType() {
        return pageType;
    }

    public void setPageType(Integer pageType) {
        this.pageType = pageType;
    }

    public String getPageDesc() {
        return pageDesc;
    }

    public void setPageDesc(String pageDesc) {
        this.pageDesc = pageDesc;
    }
}
