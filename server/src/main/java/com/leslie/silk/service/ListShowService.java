package com.leslie.silk.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.leslie.silk.entity.ListShow;
import com.leslie.silk.entity.Sildes;
import com.leslie.silk.mapper.ListShowMapper;
import com.leslie.silk.vo.SearchCommonVO;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

@Service
public class ListShowService {

    @Resource
    private ListShowMapper listShowMapper;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    
    public ListShow queryById(Integer id) {
        return this.listShowMapper.queryById(id);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    
    public List<ListShow> queryAllByLimit(int offset, int limit) {
        return this.listShowMapper.queryAllByLimit(offset, limit);
    }

    /**
     * 新增数据
     *
     * @param listShow 实例对象
     * @return 实例对象
     */
    
    public void insert(ListShow listShow) {
        listShow.setCreateTime(new Date());
        listShowMapper.insert(listShow);
    }

    /**
     * 修改数据
     *
     * @param listShow 实例对象
     * @return 实例对象
     */
    
    public void update(ListShow listShow) {
        listShowMapper.update(listShow);
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    
    public boolean deleteById(Integer id) {
        return this.listShowMapper.deleteById(id) > 0;
    }

    public List<ListShow> listShows(Integer pageType, Integer groupId) {
        ListShow listShow = new ListShow();
        listShow.setPageType(pageType);
        listShow.setGroupId(groupId);
        listShow.setActiveFlag(1);
        return listShowMapper.queryAll(listShow);
    }

    public PageInfo<ListShow> list(SearchCommonVO<ListShow> condition) {
        PageHelper.orderBy("active_flag desc, order_num asc");
        PageHelper.startPage(condition.getPageNum(), condition.getPageSize());
        return new PageInfo<>(listShowMapper.queryAll(condition.getFilters()));
    }
}
