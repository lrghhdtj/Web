package com.example.mapper;

import com.example.pojo.Collect;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;


import java.util.List;

@Repository
@Mapper
public interface CollectMapper {

    @Select("select quizid from web.collection where username= #{username}")
    List<Integer>getby(String username);

    @Select("select * from web.collection where userid = #{username} and quizid = #{quizid}")
    Collect get(String username, int quizid);

    @Insert("insert into web.collection (username,quizid) values (#{username},#{quizid})")
    void add(String username, int quizid);

    @Delete("delete from web.collection where username = #{username} and quizid = #{quizid}")
    void delete(String username, int quizid);
}
