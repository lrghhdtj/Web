package com.example.mapper;

import com.example.pojo.User;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface UserMapper {

    /**
     * @param username
     */
@Select("select * from web.user where username = #{username}")
    User getUser(String username);

    /**
     * @param username
     * @param password
     */
@Insert("insert into web.user(username,password) values (#{username},#{password})")
    void insertuser(String username, String password);
@Update("update web.user set password = #{newpassword} where username = #{username}")
    void change(String username,String newpassword);
}
