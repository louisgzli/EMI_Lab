package com.emigroup.web.dao;

import com.emigroup.web.vo.Research;
import org.apache.ibatis.annotations.*;

import java.util.List;
@Mapper
public interface ResearchMapper {
    @Insert("INSERT INTO research(title,abs,preImage,text) VALUES(#{title}, #{abs},#{preImage},#{text})")
    int insert(@Param("title") String title, @Param("abs") String abs,@Param("preImage")String preImage,
               @Param("text") String text);

    @Select("SELECT * FROM research")
    List<Research> findAll();

    @Select("SELECT * FROM research WHERE ID=#{ID}")
    Research findById(int id);

    @Delete("delete from research where id=#{id}")
    int deleteById(int id);

    @Update("update research  set title=#{title}," +
            "abs=#{abs},preImage=#{preImage},text=#{text}" +
            " where id=#{id}")
    int update(@Param("id") int id,@Param("title") String title, @Param("abs") String abs,@Param("preImage") String preImage,
               @Param("text") String text);

}
