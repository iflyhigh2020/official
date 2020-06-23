package com.leslie.silk.service;

import com.leslie.silk.entity.Banner;
import com.leslie.silk.mapper.BannerMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

@Service
public class BannerService {
    @Resource
    private BannerMapper bannerMapper;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    
    public Banner queryById(Integer id) {
        return this.bannerMapper.queryById(id);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    
    public List<Banner> queryAllByLimit(int offset, int limit) {
        return this.bannerMapper.queryAllByLimit(offset, limit);
    }

    /**
     * 新增数据
     *
     * @param banner 实例对象
     * @return 实例对象
     */
    
    public void insert(Banner banner) {
        banner.setCreateTime(new Date());
        bannerMapper.insert(banner);
    }

    /**
     * 修改数据
     *
     * @param banner 实例对象
     * @return 实例对象
     */
    
    public Banner update(Banner banner) {
        this.bannerMapper.update(banner);
        return this.queryById(banner.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    
    public boolean deleteById(Integer id) {
        return this.bannerMapper.deleteById(id) > 0;
    }

    public Banner getByType(Integer pageType, Integer groupId) {

        return bannerMapper.getByType(pageType, groupId);
    }

}