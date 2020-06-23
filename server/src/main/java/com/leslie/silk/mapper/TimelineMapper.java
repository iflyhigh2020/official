package com.leslie.silk.mapper;

import com.leslie.silk.entity.Timeline;
import org.apache.ibatis.annotations.Param;
import java.util.List;

/**
 * (Timeline)表数据库访问层
 *
 * @author makejava
 * @since 2020-04-27 09:42:28
 */
public interface TimelineMapper {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    Timeline queryById(Integer id);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<Timeline> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param timeline 实例对象
     * @return 对象列表
     */
    List<Timeline> queryAll(Timeline timeline);

    /**
     * 新增数据
     *
     * @param timeline 实例对象
     * @return 影响行数
     */
    int insert(Timeline timeline);

    /**
     * 修改数据
     *
     * @param timeline 实例对象
     * @return 影响行数
     */
    int update(Timeline timeline);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(Integer id);


    Timeline getByType(@Param("pageType") Integer pageType, @Param("groupId")Integer groupId);

    /**
     * 获取下一自增主键
     * @return
     */
    Integer getNextAutoIncrId();
}