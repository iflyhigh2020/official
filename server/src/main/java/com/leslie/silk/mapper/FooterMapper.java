package com.leslie.silk.mapper;

import com.leslie.silk.entity.Footer;
import org.apache.ibatis.annotations.Param;
import java.util.List;

/**
 * 页面footer(Footer)表数据库访问层
 *
 * @author makejava
 * @since 2020-04-29 17:08:59
 */
public interface FooterMapper {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    Footer queryById(Integer id);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<Footer> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param footer 实例对象
     * @return 对象列表
     */
    List<Footer> queryAll(Footer footer);

    /**
     * 新增数据
     *
     * @param footer 实例对象
     * @return 影响行数
     */
    int insert(Footer footer);

    /**
     * 修改数据
     *
     * @param footer 实例对象
     * @return 影响行数
     */
    int update(Footer footer);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(Integer id);

    Footer getLast();

}