package com.leslie.silk.service;

import com.leslie.silk.entity.Sildes;
import com.leslie.silk.entity.SlidesInfo;
import com.leslie.silk.mapper.SlidesInfoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/**
 * (SlidesInfo)表服务接口
 *
 * @author makejava
 * @since 2020-05-15 14:08:48
 */
@Service
public class SlidesInfoService {
    @Resource
    private SlidesInfoMapper slidesInfoMapper;


    @Autowired
    private SildesService sildesService;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    
    public SlidesInfo queryById(Integer id) {
        return this.slidesInfoMapper.queryById(id);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    
    public List<SlidesInfo> queryAllByLimit(int offset, int limit) {
        return this.slidesInfoMapper.queryAllByLimit(offset, limit);
    }

    /**
     * 新增数据
     *
     * @param slidesInfo 实例对象
     * @return 实例对象
     */
    
    public void insert(SlidesInfo slidesInfo) {
        slidesInfo.setActiveFlag(1);
        slidesInfo.setCreateTime(new Date());
        slidesInfo.setUpdateTime(new Date());
        slidesInfoMapper.insert(slidesInfo);
    }

    /**
     * 修改数据
     *
     * @param slidesInfo 实例对象
     * @return 实例对象
     */
    
    public SlidesInfo update(SlidesInfo slidesInfo) {
        this.slidesInfoMapper.update(slidesInfo);
        return this.queryById(slidesInfo.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    
    public boolean deleteById(Integer id) {
        return this.slidesInfoMapper.deleteById(id) > 0;
    }

    public SlidesInfo getByType(Integer pageType, Integer groupId) {
        SlidesInfo slidesInfo = slidesInfoMapper.getByType(pageType, groupId);
        if (null == slidesInfo) {
            slidesInfo = new SlidesInfo();
        }
        slidesInfo.setSildesList(sildesService.listSildes(pageType, groupId));
        return slidesInfo;
    }
}