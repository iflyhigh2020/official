package com.leslie.silk.service.article;


import com.leslie.silk.entity.article.ArticleCategory;
import com.leslie.silk.mapper.ArticleCategoryMapper;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author wangyong
 * @date 2019-07-11 17:28:00
 */
@Service
@Transactional
public class ArticleCategoryService {

  @Autowired
  private ArticleCategoryMapper articleCategoryMapper;


  private Logger log = LoggerFactory.getLogger(getClass());

  /**
   * 首页展示文章数据
   *
   * @return
   */
  public List<ArticleCategory> list4Home() {
    List<ArticleCategory> categoryList = articleCategoryMapper.listAllActives();
    log.info("ArticleCategoryService#list4Home6666666666666");


    return categoryList;
  }

  public List<ArticleCategory> listAllCategory() {
    return articleCategoryMapper.listAllActives();
  }


  public void add(ArticleCategory category) {
    articleCategoryMapper.insert(category);
  }

  public void update(ArticleCategory category) {
    articleCategoryMapper.update(category);
  }


  public ArticleCategory getById(Integer id) {
    return articleCategoryMapper.getById(id);
  }

}
