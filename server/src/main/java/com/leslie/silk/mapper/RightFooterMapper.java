package com.leslie.silk.mapper;

import com.leslie.silk.entity.RightFooter;
import org.apache.ibatis.annotations.Param;
import java.util.List;

/**
 * 右侧固定悬浮栏(RightFooter)表数据库访问层
 *
 * @author makejava
 * @since 2020-05-07 11:18:19
 */
public interface RightFooterMapper {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    RightFooter queryById(Integer id);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<RightFooter> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param rightFooter 实例对象
     * @return 对象列表
     */
    List<RightFooter> queryAll(RightFooter rightFooter);

    /**
     * 新增数据
     *
     * @param rightFooter 实例对象
     * @return 影响行数
     */
    int insert(RightFooter rightFooter);

    /**
     * 修改数据
     *
     * @param rightFooter 实例对象
     * @return 影响行数
     */
    int update(RightFooter rightFooter);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(Integer id);


    RightFooter getLast();
}