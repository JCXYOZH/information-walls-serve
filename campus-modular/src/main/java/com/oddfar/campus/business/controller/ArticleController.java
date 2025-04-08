package com.oddfar.campus.business.controller;


import com.oddfar.campus.business.domain.Article;
import com.oddfar.campus.business.service.ArticleService;
import com.oddfar.campus.common.annotation.ApiResource;
import com.oddfar.campus.common.domain.PageResult;
import com.oddfar.campus.common.domain.R;
import com.oddfar.campus.common.enums.ResBizTypeEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;

/**
 * 文章管理控制器
 */
@RestController
@RequestMapping("/admin/article")
@ApiResource(name = "文章管理" , appCode = "campus" , resBizType = ResBizTypeEnum.BUSINESS)
public class ArticleController {
    @Autowired
    private ArticleService articleService;

    /**
     * 查询文章列表
     */
    @PreAuthorize("@ss.resourceAuth()")
    @GetMapping(value = "/list",name = "查询文章列表")
    public R list(Article article) {
        PageResult<Article> page = articleService.page(article);

        return R.ok().put(page);
    }
    /**
     * 获取文章详细信息
     */
    @PreAuthorize("@ss.resourceAuth()")
    @GetMapping(value = "/{articleId}",name = "获取文章详细信息")
    public R getInfo(@PathVariable("articleId") Long articleId) {
        return R.ok(articleService.getById(articleId));
    }

    /**
     * 新增文章
     */
    @PreAuthorize("@ss.resourceAuth()")
    @PostMapping(value = "",name = "新增文章")
    public R add(@Validated @RequestBody Article article) {
        return R.ok(articleService.insertArticle(article));
    }

    /**
     * 修改文章
     */
    @PreAuthorize("@ss.resourceAuth()")
    @PutMapping(value = "",name = "修改文章")
    public R edit(@Validated @RequestBody Article article) {
        return R.ok(articleService.updateArticle(article));
    }

    /**
     * 删除文章
     */
    @PreAuthorize("@ss.resourceAuth()")
    @DeleteMapping(value = "/{articleIds}",name = "删除文章")
    public R remove(@PathVariable Long[] articleIds) {
        return R.ok(articleService.removeBatchByIds((Arrays.asList(articleIds))));
    }

}