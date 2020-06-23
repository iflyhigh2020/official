package com.leslie.silk.mapper;

import com.leslie.silk.entity.Logo;
import org.apache.ibatis.annotations.Param;
import java.util.List;

/**
 * logo信息表(Logo)表数据库访问层
 *
 * @author makejava
 * @since 2020-05-07 12:35:08
 */
public interface LogoMapper {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    Logo queryById(Integer id);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<Logo> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param logo 实例对象
     * @return 对象列表
     */
    List<Logo> queryAll(Logo logo);

    /**
     * 新增数据
     *
     * @param logo 实例对象
     * @return 影响行数
     */
    int insert(Logo logo);

    /**
     * 修改数据
     *
     * @param logo 实例对象
     * @return 影响行数
     */
    int update(Logo logo);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(Integer id);

    Logo getLast();

}