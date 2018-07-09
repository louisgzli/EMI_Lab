package com.emigroup.web.dao;

import com.emigroup.web.vo.Paper;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface PaperMapper { //mapper 是接口形式
    @Select("SELECT * FROM PAPER")
    List<Paper> findAll();




    @Delete("delete from paper where id=#{id}")
    int deleteById(int id);

    @Insert("INSERT INTO PAPER(title,author,journal,date,place,type) VALUES(#{title}, #{author},#{journal},#{date},#{place},#{type})")
    int insert(@Param("title") String title, @Param("author") String author,
               @Param("journal") String journal,@Param("date") String date,
               @Param("place")String place,@Param("type") String type);


    @Update("update Paper where id=#{id} set title=#{title}," +
            "author=#{author},journal=#{journal},date=#{date}," +
            "place=#{place},type=#{type}")
    int update(@Param("id") int id,@Param("title") String title, @Param("author") String author,
               @Param("journal") String journal,@Param("date") String date,
               @Param("place")String place,@Param("type") String type);
};

