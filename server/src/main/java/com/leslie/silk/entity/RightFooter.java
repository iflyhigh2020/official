package com.leslie.silk.entity;

import lombok.Data;

import java.util.Date;
import java.io.Serializable;

/**
 * 右侧固定悬浮栏(RightFooter)实体类
 *
 * @author makejava
 * @since 2020-05-07 11:18:19
 */
@Data
public class RightFooter implements Serializable {
    private static final long serialVersionUID = 325401895948480271L;
    
    private Integer id;
    
    private String col1;
    
    private String col2;
    
    private String col3;
    
    private String col4;
    
    private String col5;
    
    private String col6;
    
    private String col7;
    
    private String col8;
    /**
    * 是否激活
    */
    private Integer activeFlag;
    
    private Date updateTime;
    
    private Date createTime;



}