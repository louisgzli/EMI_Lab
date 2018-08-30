package com.emigroup.web.dao;

import com.emigroup.web.vo.News;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface NewsMapper {
    @Insert("INSERT INTO news(title,abs,text) VALUES(#{title}, #{abs},#{text})")
    int insert(@Param("title") String title, @Param("abs") String abs,
               @Param("text") String text);

    @Select("SELECT * FROM News")
    List<News> findAll();

    @Select("SELECT * FROM NEWS WHERE ID=#{ID}")
    News findById(int id);

    @Delete("delete from news where id=#{id}")
    int deleteById(int id);

    @Update("update news  set title=#{title}," +
            "abs=#{abs},text=#{text}" +
            " where id=#{id}")
    int update(@Param("id") int id,@Param("title") String title, @Param("abs") String abs,
               @Param("text") String text);


}
