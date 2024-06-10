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
    public Long count();

    @Select("select * from web.quiz limit #{start},#{pageSize}")
    public List<Quiz> page(Integer start,Integer pageSize);

}

