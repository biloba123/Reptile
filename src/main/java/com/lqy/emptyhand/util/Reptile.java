package com.lqy.emptyhand.util;

import com.lqy.emptyhand.bean.Article;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import java.io.IOException;

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
public class Reptile {
    private final static String URL_DAILY_ARTICLE="https://meiriyiwen.com";
    private final static String URL_ARTICLE=URL_DAILY_ARTICLE;
    private final static String URL_RANDOM_ARTICLE=URL_DAILY_ARTICLE+"/random";

    public static Article getArticle() {
        return getArticleByUrl(URL_ARTICLE);
    }

    public static Article getRandomArticle() {
        return getArticleByUrl(URL_RANDOM_ARTICLE);
    }

    public static Article getArticleByUrl(String url){
    Article article = null;

    try {
        Document doc=Jsoup.connect(url).get();
            Element element = doc.selectFirst("div#article_show");
        if (element!=null) {
            article = new Article();
            article.setTitle(element.selectFirst("h1").text());
            article.setAuthor(element.selectFirst("p.article_author").text());
            StringBuilder sb = new StringBuilder();
            for (Element ele : element.select("div.article_text p")) {
                sb.append(ele.text() + "\n");
            }
            article.setContent(sb.toString());
        }
    } catch (IOException e) {
        e.printStackTrace();
    }

    return article;
}
}
