package com.leslie.silk.service;

import com.leslie.silk.mapper.TimelineDetailMapper;
import com.leslie.silk.entity.TimelineDetail;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 *
 * @author makejava
 * @since 2020-04-27 09:46:25
 */
@Service
public class TimelineDetailService {

    @Resource
    private TimelineDetailMapper timelineDetailMapper;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    
    public TimelineDetail queryById(Integer id) {
        return this.timelineDetailMapper.queryById(id);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    
    public List<TimelineDetail> queryAllByLimit(int offset, int limit) {
        return this.timelineDetailMapper.queryAllByLimit(offset, limit);
    }

    /**
     * 新增数据
     *
     * @param timelineDetail 实例对象
     * @return 实例对象
     */
    
    public TimelineDetail insert(TimelineDetail timelineDetail) {
        this.timelineDetailMapper.insert(timelineDetail);
        return timelineDetail;
    }

    /**
     * 修改数据
     *
     * @param timelineDetail 实例对象
     * @return 实例对象
     */
    
    public TimelineDetail update(TimelineDetail timelineDetail) {
        this.timelineDetailMapper.update(timelineDetail);
        return this.queryById(timelineDetail.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    
    public boolean deleteById(Integer id) {
        return this.timelineDetailMapper.deleteById(id) > 0;
    }

}