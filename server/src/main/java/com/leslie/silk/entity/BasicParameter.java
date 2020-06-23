package com.leslie.silk.entity;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Date;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 参数表
 * </p>
 *
 * @author wangyong
 * @since 2019-07-04
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class BasicParameter {

  private Integer id;

  private String paramType;

  private String paramName;

  private String paramKey;

  private String paramValue;

  private Integer lanCode;

  private Integer orderNum;

  private String remark;

  private String addNo;

  private String addName;

  private Date addTime;

  private String updateNo;

  private String updateName;

  private Date updateTime;

}
