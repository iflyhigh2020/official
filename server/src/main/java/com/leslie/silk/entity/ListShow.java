package com.leslie.silk.entity;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * (ListShow)实体类
 *
 * @author makejava
 * @since 2020-04-26 14:00:19
 */
@Data
public class ListShow implements Serializable {
    private static final long serialVersionUID = 541470075280135074L;
    
    private Integer id;
    /**
    * 图片地址
    */
    private String imgUrl;
    /**
    * 点击跳转地址
    */
    private String targetUrl;
    /**
    * 标题
    */
    private String title;
    /**
    * 文字内容
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
    * 区分同一页面内的哪个列表组件，123..来表示
    */
    private Integer groupId;
    /**
    * 创建时间
    */
    private Date createTime;

}