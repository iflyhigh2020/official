package com.leslie.silk.service;

import com.leslie.silk.entity.Footer;
import com.leslie.silk.mapper.FooterMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/**
 * 页面footer(Footer)表服务接口
 *
 * @author makejava
 * @since 2020-04-29 17:09:00
 */
@Service
public class FooterService {
    @Resource
    private FooterMapper footerMapper;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    
    public Footer queryById(Integer id) {
        return this.footerMapper.queryById(id);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    
    public List<Footer> queryAllByLimit(int offset, int limit) {
        return this.footerMapper.queryAllByLimit(offset, limit);
    }

    /**
     * 新增数据
     *
     * @param footer 实例对象
     * @return 实例对象
     */
    
    public void insert(Footer footer) {
        footer.setCreateTime(new Date());
        footerMapper.insert(footer);
    }

    /**
     * 修改数据
     *
     * @param footer 实例对象
     * @return 实例对象
     */
    
    public Footer update(Footer footer) {
        this.footerMapper.update(footer);
        return this.queryById(footer.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    
    public boolean deleteById(Integer id) {
        return this.footerMapper.deleteById(id) > 0;
    }

    public Footer getCurrentFooter() {
        return footerMapper.getLast();
    }
}