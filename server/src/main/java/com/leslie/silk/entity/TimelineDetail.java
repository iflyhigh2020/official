package com.leslie.silk.entity;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * (TimelineDetail)实体类
 *
 * @author makejava
 * @since 2020-04-27 09:46:24
 */
@Data
public class TimelineDetail implements Serializable {
    private static final long serialVersionUID = -66436050603220808L;
    
    private Integer id;
    
    private Integer timelineId;
    
    private Date dateNode;
    
    private String title;
    
    private String content;

}