package com.leslie.silk.mapper;

import com.leslie.silk.entity.ImgText;
import org.apache.ibatis.annotations.Param;
import java.util.List;

/**
 * (ImgText)表数据库访问层
 *
 * @author makejava
 * @since 2020-04-26 14:57:05
 */
public interface ImgTextMapper {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    ImgText queryById(Integer id);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<ImgText> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param imgText 实例对象
     * @return 对象列表
     */
    List<ImgText> queryAll(ImgText imgText);

    /**
     * 新增数据
     *
     * @param imgText 实例对象
     * @return 影响行数
     */
    int insert(ImgText imgText);

    /**
     * 修改数据
     *
     * @param imgText 实例对象
     * @return 影响行数
     */
    int update(ImgText imgText);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(Integer id);



    ImgText getByType(@Param("pageType") Integer pageType, @Param("groupId")Integer groupId);

}