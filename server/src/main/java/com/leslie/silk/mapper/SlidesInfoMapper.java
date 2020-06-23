package com.leslie.silk.mapper;

import com.leslie.silk.entity.SlidesInfo;
import org.apache.ibatis.annotations.Param;
import java.util.List;

/**
 * (SlidesInfo)表数据库访问层
 *
 * @author makejava
 * @since 2020-05-15 14:08:47
 */
public interface SlidesInfoMapper {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    SlidesInfo queryById(Integer id);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<SlidesInfo> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param slidesInfo 实例对象
     * @return 对象列表
     */
    List<SlidesInfo> queryAll(SlidesInfo slidesInfo);

    /**
     * 新增数据
     *
     * @param slidesInfo 实例对象
     * @return 影响行数
     */
    int insert(SlidesInfo slidesInfo);

    /**
     * 修改数据
     *
     * @param slidesInfo 实例对象
     * @return 影响行数
     */
    int update(SlidesInfo slidesInfo);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(Integer id);

    SlidesInfo getByType(Integer pageType, Integer groupId);

}