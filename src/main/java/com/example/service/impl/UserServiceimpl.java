package com.example.service.impl;

import com.example.Utils.Jwtutils;
import com.example.Utils.Result;
import com.example.mapper.UserMapper;
import com.example.pojo.User;
import com.example.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;

@Service
@Slf4j
public class UserServiceimpl implements UserService {

    @Autowired
    private UserMapper userMapper;
    @Override
    public String login(String username , String password) {
        //根据用户查询用户的信息
        User user = userMapper.getUser(username);
        if (user == null){
            return "unexist";
        }
        //判断密码是否正确
        if (!user.getPassword().equals(password)){
            return "perror";
        }
        //生成jwt令牌并返回
        HashMap<String, Object> claims = new HashMap<>();
        claims.put("id",user.getId());
        claims.put("username",user.getUsername());
        claims.put("password",user.getPassword());
        String jwt = Jwtutils.generateJwt(claims);
        return jwt;
//        return "success";
    }

    @Override
    public String register(String usernmae , String password) {
        User u = userMapper.getUser(usernmae);
        if (u == null){
            userMapper.insertuser(usernmae ,password);
             return "success";
        }else {
            return "error";
        }
    }


}
