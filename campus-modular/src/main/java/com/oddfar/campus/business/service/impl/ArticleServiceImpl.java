package com.oddfar.campus.business.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.oddfar.campus.business.domain.Article;
import com.oddfar.campus.business.mapper.ArticleMapper;
import com.oddfar.campus.business.service.ArticleService;
import com.oddfar.campus.common.domain.PageResult;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * 文章管理业务实现层
 */
@Service
public class ArticleServiceImpl extends ServiceImpl<ArticleMapper, Article>
        implements ArticleService {

    @Resource
    private ArticleMapper articleMapper;

    @Override
    public PageResult<Article> page(Article article) {

        return articleMapper.page(article);
    }

    @Override
    public int insertArticle(Article article) {

        return articleMapper.insert(article);
    }

    @Override
    public int updateArticle(Article article) {
        return articleMapper.updateById(article);
    }

    @Override
    public int deleteArticle(Article article) {
        return articleMapper.deleteById(article.getArticleId());
    }
}