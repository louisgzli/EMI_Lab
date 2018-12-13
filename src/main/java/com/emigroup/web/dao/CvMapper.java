package com.emigroup.web.dao;

import com.emigroup.web.vo.Cv;
import org.apache.ibatis.annotations.*;

import java.util.List;
@Mapper
public interface CvMapper {
    @Insert("INSERT INTO cv(username,position,userdes,imgpath,email,interest,office,award)VALUES(#{username}, #{position},#{userdes},#{imgpath},#{email},#{interest},#{office},#{award})")
    int insert(@Param("username") String username, @Param("position") String position,@Param("userdes")String userdes,
               @Param("imgpath") String imgpath,@Param("email")String email,@Param("interest")String interest,@Param("office")String office,@Param("award")String award);

    @Select("SELECT * FROM cv")
    List<Cv> findAll();

    @Select("SELECT * FROM cv WHERE ID=#{ID}")
    Cv findById(int id);

    @Delete("delete from cv where id=#{id}")
    int deleteById(int id);

    @Update("update cv  set username=#{username}," +
            "position=#{position},userdes=#{userdes},imgpath=#{imgpath},email=#{email},interest=#{interest},office=#{office},award=#{award}" +
            " where id=#{id}")
    int update(@Param("id") int id,@Param("username") String username, @Param("position") String position,
               @Param("userdes") String userdes,@Param("imgpath")String imgpath,@Param("email")String email,@Param("interest")String interest,@Param("office")String office,@Param("award")String award);
}
