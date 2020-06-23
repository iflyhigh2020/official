package com.leslie.silk.service;

import com.leslie.silk.entity.BasicParameter;
import com.leslie.silk.mapper.BasicParameterMapper;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author wangyong
 * @since 2019-07-09
 */
@Service
@Transactional
public class BasicParameterService {


  private final BasicParameterMapper basicParameterMapper;

  @Autowired
  public BasicParameterService(BasicParameterMapper basicParameterMapper) {
    this.basicParameterMapper = basicParameterMapper;
  }

  public BasicParameter getById(Integer id) {
    return basicParameterMapper.selectById(id);
  }


  public List<BasicParameter> listByType(String paramType) {
    return basicParameterMapper.listByType(paramType);
  }

}
