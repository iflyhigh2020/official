package com.leslie.silk.mapper;

import com.leslie.silk.entity.article.ArticleCategory;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ArticleCategoryMapper {


  List<ArticleCategory> listAllActives();

  int update(ArticleCategory articleCategory);

  ArticleCategory getById(@Param("id") Integer id);

  int insert(ArticleCategory articleCategory);

}
