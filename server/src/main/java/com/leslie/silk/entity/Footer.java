package com.leslie.silk.entity;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 页面footer(Footer)实体类
 *
 * @author makejava
 * @since 2020-04-29 17:08:59
 */
@Data
public class Footer implements Serializable {
    private static final long serialVersionUID = -23502261335845908L;
    
    private Integer id;
    /**
    * 标题
    */
    private String title;
    
    private String text1;
    
    private String text2;
    
    private String text3;
    
    private String text4;
    
    private String text5;
    /**
    * 背景色
    */
    private String bgColor;
    
    private String fontColor;

    private Date createTime;

}