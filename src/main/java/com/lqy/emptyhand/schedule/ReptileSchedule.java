package com.lqy.emptyhand.schedule;

import com.lqy.emptyhand.bean.Article;
import com.lqy.emptyhand.service.ArticleService;
import com.lqy.emptyhand.util.Reptile;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

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
@Component
public class ReptileSchedule {
    @Autowired
    private ArticleService mArticleService;

    @Scheduled(fixedDelay = 6*60*60*1000)
    public void crawlArticle(){
        try {
            Article article=Reptile.getArticle();
            for (; article==null ; Thread.sleep(5000)){
                article=Reptile.getArticle();
            }
            mArticleService.addOrUpdateArticle(article);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
