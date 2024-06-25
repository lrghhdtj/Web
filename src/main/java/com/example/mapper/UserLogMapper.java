package com.example.mapper;

import com.example.pojo.UserLog;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
@Mapper
public interface UserLogMapper {
    @Select("select * from userlog where userid = #{userid}")
    List<UserLog> get(int userid);

    @Delete("delete from userlog where userid = #{userid} and id = #{id}")
    void delete(int userid, int id);

    @Insert("insert into userlog (userid,quizid,time) values (#{userid},#{quizid},#{time})")
    void add(int userid, int quizid, Date time);

    @Delete("delete from userlog where userid = #{userid}")
    void clear(int userid);
}
