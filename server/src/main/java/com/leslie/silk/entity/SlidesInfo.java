package com.leslie.silk.entity;

import lombok.Data;

import java.util.Date;
import java.io.Serializable;
import java.util.List;

/**
 * (SlidesInfo)实体类
 *
 * @author makejava
 * @since 2020-05-15 14:08:47
 */
@Data
public class SlidesInfo implements Serializable {
    private static final long serialVersionUID = -47899180675906516L;
    
    private Integer id;
    /**
    * 高度像素，单位px
    */
    private Integer height;
    /**
    * 宽度百分比，最大100，最小0
    */
    private Integer width;
    
    private Date createTime;
    
    private Date updateTime;
    
    private Integer pageType;
    
    private Integer groupId;
    
    private Integer activeFlag;

    private List<Sildes> sildesList;

}