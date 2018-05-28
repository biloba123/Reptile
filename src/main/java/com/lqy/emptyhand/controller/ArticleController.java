package com.lqy.emptyhand.controller;

import com.lqy.emptyhand.bean.Article;
import com.lqy.emptyhand.service.ArticleService;
import com.lqy.emptyhand.util.Reptile;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 一句话功能描述
 * 功能详细描述
 *
 * @author Lv Qingyang
 * @date 2018/5/27
 * @email biloba12345@gamil.com
 * @github https://github.com/biloba123
 * @blog https://biloba123.github.io/
 * @see
 * @since
 */
@RestController
@RequestMapping("/article")
public class ArticleController {
    @Autowired
    private ArticleService mArticleService;

    @RequestMapping("/today")
    public Article getTodayArticle(){
        return mArticleService.getTodayArticle();
    }

    @RequestMapping("/random")
    public Article getRandomArticle(){
        return Reptile.getRandomArticle();
    }

}
