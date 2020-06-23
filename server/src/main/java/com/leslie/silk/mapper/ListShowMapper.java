package com.leslie.silk.mapper;

import com.leslie.silk.entity.ListShow;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * (ListShow)表数据库访问层
 *
 * @author makejava
 * @since 2020-04-26 14:00:20
 */
public interface ListShowMapper {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    ListShow queryById(Integer id);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<ListShow> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param listShow 实例对象
     * @return 对象列表
     */
    List<ListShow> queryAll(ListShow listShow);

    /**
     * 新增数据
     *
     * @param listShow 实例对象
     * @return 影响行数
     */
    int insert(ListShow listShow);

    /**
     * 修改数据
     *
     * @param listShow 实例对象
     * @return 影响行数
     */
    int update(ListShow listShow);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(Integer id);

}