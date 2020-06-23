package com.leslie.silk.entity;

import lombok.Data;

import java.util.Date;
import java.io.Serializable;

/**
 * (Banner)实体类
 *
 * @author makejava
 * @since 2020-04-26 17:01:36
 */
@Data
public class Banner implements Serializable {
    private static final long serialVersionUID = 950186295808315400L;
    
    private Integer id;
    /**
    * 图片地址
    */
    private String imgUrl;
    /**
    * 标题
    */
    private String title;
    /**
    * 内容文字
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

    /**
     * 高度
     */
    private Integer height;

}