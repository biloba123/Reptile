package com.lqy.emptyhand.mapper;

import com.lqy.emptyhand.bean.Article;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

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
@Mapper
public interface IArticleMapper {

    @Insert("insert into article values(null, #{title}, #{author}, #{content}, #{date})")
    int addArticle(Article article);

    @Update("update article set title=#{title}, author=#{author}, content=#{content}, date=#{date} where id=#{id}")
    int updateArticle(Article article);

    @Select("select * from article where date=#{date}")
    Article findArticleByDate(String date);
}
