package com.example.mapper;

import com.example.pojo.Quiz;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
@Mapper
public interface QuizMapper {


    /**
     * @param id
     */
    @Select("select * from web.quiz where id =#{id}")
    Quiz find(int id);

    @Select("select * from web.quiz")
    List<Quiz> get();

    @Select("select count(*) from web.quiz")
    Long count();

    @Select("select * from web.quiz limit #{start},#{pageSize}")
    List<Quiz> page(Integer start,Integer pageSize);

    @Select("select quizid from web.top order by score desc limit 5;")
    List<Integer> topfive();
}

