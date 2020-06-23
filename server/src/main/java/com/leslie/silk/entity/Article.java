package com.leslie.silk.entity;

import lombok.Data;

import java.util.Date;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/**
 * 文章表(Article)实体类
 *
 * @author makejava
 * @since 2020-05-19 15:12:22
 */
@Data
public class Article implements Serializable {
    private static final long serialVersionUID = -32555680018709333L;

    public static final Map<Integer, String> groupMap = new HashMap<Integer, String>() {{
       put(1, "公司信息");
       put(2, "品牌信息");
    }};
    
    private Integer id;
    /**
    * 文章标题
    */
    private String articleTitle;
    /**
    * 页面分类
    */
    private Integer pageType;
    /**
    * 页面分类名
    */
    private String pageName;
    /**
    * 页面内的组件
    */
    private Integer groupId;
    /**
    * 页面内的组件名
    */
    private String groupName;
    
    private String content;
    /**
    * 是否激活。0激活，1禁用
    */
    private Integer activeFlag;
    /**
    * 添加时间
    */
    private Date addTime;
    /**
    * 修改时间
    */
    private Date updateTime;


}