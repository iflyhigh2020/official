package com.leslie.silk.entity;

import lombok.Data;

import java.util.Date;
import java.io.Serializable;
import java.util.List;

/**
 * (Timeline)实体类
 *
 * @author makejava
 * @since 2020-04-27 09:42:28
 */
@Data
public class Timeline implements Serializable {
    private static final long serialVersionUID = 246415872058697377L;
    
    private Integer id;
    /**
    * 标题
    */
    private String title;

    private String titleEn;

    /**
    * 背景图地址，不填则无背景图
    */
    private String bgUrl;
    /**
    * 背景图颜色，不填则无背景色
    */
    private String bgColor;
    /**
    * 内容文字（预留一下）
    */
    private String content;
    /**
    * 是否生效。0否1是
    */
    private Integer activeFlag;
    /**
    * 页面类型。对应关系代码中找
    */
    private Integer pageType;
    /**
    * 区分同一页面内的哪个组件，123..来表示
    */
    private Integer groupId;
    /**
    * 创建时间
    */
    private Date createTime;

    private List<TimelineDetail> detailList;

}