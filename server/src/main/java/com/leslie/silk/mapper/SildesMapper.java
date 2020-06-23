package com.leslie.silk.mapper;

import com.leslie.silk.entity.Sildes;
import org.apache.ibatis.annotations.Param;
import java.util.List;

/**
 * (Sildes)表数据库访问层
 *
 * @author makejava
 * @since 2020-04-26 09:48:25
 */
public interface SildesMapper {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    Sildes queryById(Integer id);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<Sildes> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param sildes 实例对象
     * @return 对象列表
     */
    List<Sildes> queryAll(Sildes sildes);

    /**
     * 新增数据
     *
     * @param sildes 实例对象
     * @return 影响行数
     */
    int insert(Sildes sildes);

    /**
     * 修改数据
     *
     * @param sildes 实例对象
     * @return 影响行数
     */
    int update(Sildes sildes);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(Integer id);

}