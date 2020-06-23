package com.leslie.silk.service;

import com.leslie.silk.entity.Logo;
import com.leslie.silk.mapper.LogoMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/**
 * logo信息表(Logo)表服务接口
 *
 * @author makejava
 * @since 2020-05-07 12:35:09
 */
@Service
public class LogoService {
    @Resource
    private LogoMapper logoMapper;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */

    public Logo queryById(Integer id) {
        return this.logoMapper.queryById(id);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */

    public List<Logo> queryAllByLimit(int offset, int limit) {
        return this.logoMapper.queryAllByLimit(offset, limit);
    }

    /**
     * 新增数据
     *
     * @param logo 实例对象
     * @return 实例对象
     */

    public void insert(Logo logo) {
        logo.setCreateTime(new Date());
        logoMapper.insert(logo);
    }

    /**
     * 修改数据
     *
     * @param logo 实例对象
     * @return 实例对象
     */

    public Logo update(Logo logo) {
        this.logoMapper.update(logo);
        return this.queryById(logo.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */

    public boolean deleteById(Integer id) {
        return this.logoMapper.deleteById(id) > 0;
    }

    public Logo getCurrent() {
        return logoMapper.getLast();
    }
}