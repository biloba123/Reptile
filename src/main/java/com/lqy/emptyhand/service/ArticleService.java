package com.lqy.emptyhand.service;

import com.lqy.emptyhand.bean.Article;
import com.lqy.emptyhand.mapper.IArticleMapper;
import com.lqy.emptyhand.util.Reptile;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

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
@Service
public class ArticleService {
    private IArticleMapper mArticleMapper;

    @Autowired
    public ArticleService(IArticleMapper articleMapper) {
        mArticleMapper = articleMapper;
    }

    public boolean addArticle(Article article){
        return mArticleMapper.addArticle(article)==1;
    }

    public boolean updateArticle(Article article){
        return mArticleMapper.updateArticle(article)==1;
    }

    public boolean addOrUpdateArticle(Article article){
        if (article==null){
            return false;
        }

        Article oldArticle=mArticleMapper.findArticleByDate(article.getDate());
        if (oldArticle == null) {
            return addArticle(article);
        }else {
            return updateArticle(article);
        }
    }

    public Article getTodayArticle(){
        Article article=mArticleMapper.findArticleByDate(Article.DATE_FORMAT.format(new Date()));
        if (article == null) {
            article=Reptile.getArticle();
            mArticleMapper.addArticle(article);
        }
        return article;
    }
}
