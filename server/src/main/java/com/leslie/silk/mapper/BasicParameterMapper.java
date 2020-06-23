package com.leslie.silk.mapper;

import com.leslie.silk.entity.BasicParameter;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * <p>
 * 参数表 Mapper 接口
 * </p>
 *
 * @author wangyong
 * @since 2019-07-04
 */
public interface BasicParameterMapper {

  BasicParameter selectById(@Param("id") Integer id);

  List<BasicParameter> listByType(@Param("paramType") String paramType);
}
