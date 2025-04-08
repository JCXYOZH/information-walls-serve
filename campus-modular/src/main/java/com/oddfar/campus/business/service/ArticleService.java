package com.oddfar.campus.business.service;

import com.oddfar.campus.business.domain.Article;
import com.baomidou.mybatisplus.extension.service.IService;
import com.oddfar.campus.common.domain.PageResult;

/**
 * 文章管理业务
 */
public interface ArticleService extends IService<Article> {
    /**
     * 查询文章分页数据
     *
     * @param article 文章
     * @return 分页数据
     */
    PageResult<Article> page(Article article);

    /**
     * 新增文章
     *
     * @param article 文章
     * @return 结果
     */
    int insertArticle(Article article);

    /**
     * 更新标签
     *
     * @param article 文章
     * @return 结果
     */
    int updateArticle(Article article);

    /**
     * 删除标签
     *
     * @param article 文章
     * @return 结果
     */
    int deleteArticle(Article article);

}