package com.leslie.silk.service;

import com.leslie.silk.entity.TimelineDetail;
import com.leslie.silk.mapper.TimelineDetailMapper;
import com.leslie.silk.mapper.TimelineMapper;
import com.leslie.silk.entity.Timeline;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/**
 * (Timeline)表服务接口
 *
 * @author makejava
 * @since 2020-04-27 09:42:32
 */
@Service
public class TimelineService {
    @Resource
    private TimelineMapper timelineMapper;

    @Autowired
    private TimelineDetailMapper timelineDetailMapper;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */

    public Timeline queryById(Integer id) {
        return this.timelineMapper.queryById(id);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */

    public List<Timeline> queryAllByLimit(int offset, int limit) {
        return this.timelineMapper.queryAllByLimit(offset, limit);
    }

    /**
     * 新增数据
     *
     * @param timeline 实例对象
     * @return 实例对象
     */
    @Transactional(rollbackFor = Exception.class)
    public void insert(Timeline timeline) throws Exception{
        List<TimelineDetail> details = timeline.getDetailList();
        if (CollectionUtils.isEmpty(details)) {
            throw new Exception("节点信息不能为空");
        }
        Integer timelineId = timelineMapper.getNextAutoIncrId();
        timeline.setId(timelineId);
        timeline.setCreateTime(new Date());
        timelineMapper.insert(timeline);
        saveDetails(details, timelineId);
    }

    private void saveDetails(List<TimelineDetail> details, Integer timelineId) {
        for (TimelineDetail detail : details) {
            detail.setTimelineId(timelineId);
            timelineDetailMapper.insert(detail);
        }
    }

    /**
     * 修改数据
     *
     * @param timeline 实例对象
     * @return 实例对象
     */

    public Timeline update(Timeline timeline) {
        this.timelineMapper.update(timeline);
        return this.queryById(timeline.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */

    public boolean deleteById(Integer id) {
        return this.timelineMapper.deleteById(id) > 0;
    }

    public Timeline getByType(Integer pageType, Integer groupId) {
        Timeline timeline = timelineMapper.getByType(pageType, groupId);
        if (null == timeline) {
            return null;
        }
        timeline.setDetailList(timelineDetailMapper.listByTimelineId(timeline.getId()));
        return timeline;
    }

}