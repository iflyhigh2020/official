package com.leslie.silk.mapper;

import com.leslie.silk.entity.TimelineDetail;
import org.apache.ibatis.annotations.Param;
import java.util.List;

/**
 * (TimelineDetail)表数据库访问层
 *
 * @author makejava
 * @since 2020-04-27 09:46:24
 */
public interface TimelineDetailMapper {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    TimelineDetail queryById(Integer id);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<TimelineDetail> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param timelineDetail 实例对象
     * @return 对象列表
     */
    List<TimelineDetail> queryAll(TimelineDetail timelineDetail);

    /**
     * 新增数据
     *
     * @param timelineDetail 实例对象
     * @return 影响行数
     */
    int insert(TimelineDetail timelineDetail);

    /**
     * 修改数据
     *
     * @param timelineDetail 实例对象
     * @return 影响行数
     */
    int update(TimelineDetail timelineDetail);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(Integer id);

    List<TimelineDetail> listByTimelineId(Integer timelineId);
}