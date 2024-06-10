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
    /**
     * @param userid
     * @return
     */
    @Select("select quizid from web.collection where userid= #{userid}")
    List<Integer>getby(int userid);

    @Select("select * from web.collection where userid = #{userid} and quizid = #{quizid}")
    Collect get(int userid, int quizid);

    @Insert("insert into web.collection (userid,quizid) values (#{userid},#{quizid})")
    void add(int userid, Integer quizid);

    @Delete("DELETE from web.collection where userid = #{userid} and quizid = #{quizid}")
    void delete(int userid, int quizid);
}
