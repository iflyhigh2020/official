package com.leslie.silk.entity;

import lombok.Data;

import java.util.Date;
import java.io.Serializable;

/**
 * (ImgText)实体类
 *
 * @author makejava
 * @since 2020-04-26 14:57:05
 */
@Data
public class ImgText implements Serializable {
    private static final long serialVersionUID = 320690144751978647L;
    
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
    * 图片另一侧文字内容
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
    * 区分同一页面内的哪个图文组件，123..来表示
    */
    private Integer groupId;
    /**
    * 创建时间
    */
    private Date createTime;

    private Integer height;

    private Integer width;
}