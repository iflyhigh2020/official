package com.leslie.silk.vo;

/**
 * @author wangyong
 */
public class SearchCommonVO<T> {

  private int pageNum;

  private int pageSize;

  private T filters;

  private String sort;

  public int getPageNum() {
    return pageNum;
  }

  public void setPageNum(int pageNum) {
    this.pageNum = pageNum;
  }

  public int getPageSize() {

    return pageSize;
  }

  public void setPageSize(int pageSize) {
    this.pageSize = pageSize;
  }

  public T getFilters() {
    return filters;
  }

  public void setFilters(T filters) {
    this.filters = filters;
  }

  public String getSort() {
    return sort;
  }

  public void setSort(String sort) {
    this.sort = sort;
  }
}
