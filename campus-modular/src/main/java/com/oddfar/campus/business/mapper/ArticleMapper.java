package com.oddfar.campus.business.mapper;

import com.oddfar.campus.business.domain.Article;
import com.oddfar.campus.common.core.BaseMapperX;
import com.oddfar.campus.common.core.LambdaQueryWrapperX;
import com.oddfar.campus.common.domain.PageResult;

/**
 * 文章管理Mapper
 */
public interface ArticleMapper extends BaseMapperX<Article> {

    default PageResult<Article> page(Article article) {

        return selectPage(new LambdaQueryWrapperX<Article>()
                .likeIfPresent(Article::getArticleTitle, article.getArticleTitle())
                .likeIfPresent(Article::getArticleContent, article.getArticleContent())
                .eqIfPresent(Article::getIsAnonymous, article.getIsAnonymous())
                .betweenIfPresent(Article::getCreateTime,article.getParams())
        );
    }

}