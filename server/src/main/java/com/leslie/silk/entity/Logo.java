package com.leslie.silk.entity;

import lombok.Data;

import java.util.Date;
import java.io.Serializable;

/**
 * logo信息表(Logo)实体类
 *
 * @author makejava
 * @since 2020-05-07 12:35:07
 */
@Data
public class Logo implements Serializable {
    private static final long serialVersionUID = -24885741717661317L;
    
    private Integer id;
    
    private String logoUrl;
    
    private Date createTime;
    /**
    * 是否激活
    */
    private Integer activeFlag;

    /**
     * 向右移动的像素
     */
    private Integer paddingLeft;

}