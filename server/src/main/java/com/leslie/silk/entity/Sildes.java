package com.leslie.silk.entity;

import lombok.Data;

import java.util.Date;
import java.io.Serializable;

/**
 * (Sildes)实体类
 *
 * @author makejava
 * @since 2020-04-26 09:48:25
 */
@Data
public class Sildes implements Serializable {
    private static final long serialVersionUID = 940332339374810773L;
    
    private Integer id;
    /**
    * 图片地址
    */
    private String imgUrl;
    /**
    * 点击图片跳转地址
    */
    private String targetUrl;
    /**
    * 图片标题
    */
    private String title;
    /**
    * 图片文字内容
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
    * 顺序，数字小在前
    */
    private Integer orderNum;
    /**
    * 区分同一页面内的哪个轮播组件，123..来表示
    */
    private Integer groupId;
    /**
    * 图片上传时间
    */
    private Date createTime;

}