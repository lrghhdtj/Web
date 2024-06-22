package com.example.mapper;

import com.example.pojo.Comment;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Mapper
@Repository
public interface CommentMapper {
    @Select("select * from web.comment where quizid = #{quizid}")
    List<Comment> selectAll(int quizid);

    @Insert("insert into web.comment (username,quizid,comment,goal,createtime) values (#{username},#{quizid},#{comment},#{goal},#{createtime})")
    void addcomment(String username, int quizid, String comment, int goal, Date createtime);
    @Delete("delete from web.comment where username = #{username} and quizid = #{quizid}")
    void deletecomment(String username,int quizid);

    @Select("select * from web.comment where username = #{username} and quizid = #{quizid}")
    Comment get(String username,int quizid);
}
