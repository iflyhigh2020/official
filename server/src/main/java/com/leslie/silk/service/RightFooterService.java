package com.leslie.silk.service;

import com.leslie.silk.entity.RightFooter;
import com.leslie.silk.mapper.RightFooterMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/**
 * 右侧固定悬浮栏(RightFooter)表服务接口
 *
 * @author makejava
 * @since 2020-05-07 11:18:20
 */
@Service
public class RightFooterService {
    @Resource
    private RightFooterMapper rightFooterMapper;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    
    public RightFooter queryById(Integer id) {
        return this.rightFooterMapper.queryById(id);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    
    public List<RightFooter> queryAllByLimit(int offset, int limit) {
        return this.rightFooterMapper.queryAllByLimit(offset, limit);
    }

    /**
     * 新增数据
     *
     * @param rightFooter 实例对象
     * @return 实例对象
     */
    
    public void insert(RightFooter rightFooter) {
        rightFooter.setCreateTime(new Date());
        rightFooter.setUpdateTime(new Date());
        rightFooterMapper.insert(rightFooter);
    }

    /**
     * 修改数据
     *
     * @param rightFooter 实例对象
     * @return 实例对象
     */
    
    public RightFooter update(RightFooter rightFooter) {
        rightFooter.setUpdateTime(new Date());
        this.rightFooterMapper.update(rightFooter);
        return this.queryById(rightFooter.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    
    public boolean deleteById(Integer id) {
        return this.rightFooterMapper.deleteById(id) > 0;
    }

    public RightFooter getCurrent() {
        return rightFooterMapper.getLast();
    }
}