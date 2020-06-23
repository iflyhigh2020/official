package com.leslie.silk.service;

import com.leslie.silk.entity.ImgText;
import com.leslie.silk.mapper.ImgTextMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/**
 *
 * @author makejava
 * @since 2020-04-26 14:57:06
 */
@Service
public class ImgTextService {
    @Resource
    private ImgTextMapper imgTextMapper;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    
    public ImgText queryById(Integer id) {
        return this.imgTextMapper.queryById(id);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    
    public List<ImgText> queryAllByLimit(int offset, int limit) {
        return this.imgTextMapper.queryAllByLimit(offset, limit);
    }

    /**
     * 新增数据
     *
     * @param imgText 实例对象
     * @return 实例对象
     */
    public void insert(ImgText imgText) {
        imgText.setCreateTime(new Date());
        imgTextMapper.insert(imgText);
    }

    /**
     * 修改数据
     *
     * @param imgText 实例对象
     * @return 实例对象
     */
    public ImgText update(ImgText imgText) {
        this.imgTextMapper.update(imgText);
        return this.queryById(imgText.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    
    public boolean deleteById(Integer id) {
        return this.imgTextMapper.deleteById(id) > 0;
    }


    public ImgText getByType(Integer pageType, Integer groupId) {

        return imgTextMapper.getByType(pageType, groupId);
    }
}