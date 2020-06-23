package com.leslie.silk.service;

import com.leslie.silk.enums.ArticleStatusEnum;
import com.leslie.silk.mapper.ArticleMapper;
import com.leslie.silk.entity.Article;
import io.swagger.models.auth.In;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/**
 * 文章表(Article)表服务接口
 *
 * @author makejava
 * @since 2020-05-19 15:12:24
 */
@Service
public class ArticleService {
    @Resource
    private ArticleMapper articleMapper;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    
    public Article queryById(Integer id) {
        return this.articleMapper.queryById(id);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    
    public List<Article> queryAllByLimit(int offset, int limit) {
        return this.articleMapper.queryAllByLimit(offset, limit);
    }

    /**
     * 新增数据
     *
     * @param article 实例对象
     * @return 实例对象
     */
    
    public void insert(Article article) {
        article.setActiveFlag(1);
        article.setAddTime(new Date());
        article.setUpdateTime(new Date());
        article.setPageName(ArticleStatusEnum.getDescByStatus(article.getPageType()));
        article.setGroupName(Article.groupMap.get(article.getGroupId()));
        articleMapper.insert(article);
    }

    /**
     * 修改数据
     *
     * @param article 实例对象
     * @return 实例对象
     */
    
    public Article update(Article article) {
        this.articleMapper.update(article);
        return this.queryById(article.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    
    public boolean deleteById(Integer id) {
        return this.articleMapper.deleteById(id) > 0;
    }

    public Article getByType(Integer pageType, Integer groupId) {
        return articleMapper.getByType(pageType, groupId);
    }
}