package com.oddfar.campus.business.domain;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.oddfar.campus.common.domain.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.io.Serializable;

/**
 * 文章管理实体类
 * @TableName article
 */
@TableName(value ="article")
@Data
@EqualsAndHashCode(callSuper = true)
public class Article extends BaseEntity implements Serializable {
    /**
     * 文章id
     */
    @TableId
    private Long articleId;

    /**
     * 文章标题
     */
    @NotBlank(message = "文章标题不能为空")
    @Size(min = 0, max = 100, message = "文章标题不能超过100个字符")
    private String articleTitle;

    /**
     * 文章内容
     */
    @NotBlank(message = "文章内容不能为空")
    @Size(min = 0, max = 1000, message = "文章内容不能超过1000个字符")
    private String articleContent;

    /**
     * 0不匿名，1匿名
     */
    private Integer isAnonymous;


    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}