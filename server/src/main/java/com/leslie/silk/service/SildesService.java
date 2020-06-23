package com.leslie.silk.service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.leslie.silk.entity.Sildes;
import com.leslie.silk.mapper.SildesMapper;
import com.leslie.silk.vo.SearchCommonVO;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/**
 * (Sildes)表服务实现类
 *
 * @author makejava
 * @since 2020-04-26 09:48:30
 */
@Service("sildesService")
public class SildesService {
    @Resource
    private SildesMapper sildesMapper;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    
    public Sildes queryById(Integer id) {
        return this.sildesMapper.queryById(id);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    
    public List<Sildes> queryAllByLimit(int offset, int limit) {
        return this.sildesMapper.queryAllByLimit(offset, limit);
    }

    /**
     * 新增数据
     *
     * @param sildes 实例对象
     * @return 实例对象
     */
    
    public void insert(Sildes sildes) {
        sildes.setCreateTime(new Date());
        sildesMapper.insert(sildes);
    }

    /**
     * 修改数据
     *
     * @param sildes 实例对象
     * @return 实例对象
     */
    
    public void update(Sildes sildes) {
        sildesMapper.update(sildes);
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    
    public boolean deleteById(Integer id) {
        return this.sildesMapper.deleteById(id) > 0;
    }

    public List<Sildes> listSildes(Integer pageType, Integer groupId) {
        Sildes sildes = new Sildes();
        sildes.setPageType(pageType);
        sildes.setGroupId(groupId);
        sildes.setActiveFlag(1);
        return sildesMapper.queryAll(sildes);
    }

    public PageInfo<Sildes> list(SearchCommonVO<Sildes> condition) {
        PageHelper.orderBy("active_flag desc, order_num asc");
        PageHelper.startPage(condition.getPageNum(), condition.getPageSize());
        return new PageInfo<>(sildesMapper.queryAll(condition.getFilters()));
    }
}