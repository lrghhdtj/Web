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
    public Result login(String username , String password) {
        //根据用户查询用户的信息
        User user = userMapper.getUser(username);
        if (user == null){
            return Result.error("用户不存在！");
        }
        //判断密码是否正确
        if (!user.getPassword().equals(password)){
            return Result.error("密码错误！");
        }
        //生成jwt令牌并返回
        HashMap<String, Object> claims = new HashMap<>();
        claims.put("id",user.getId());
        claims.put("username",user.getUsername());
        claims.put("password",user.getPassword());
        String jwt = Jwtutils.generateJwt(claims);
        return Result.success(jwt);
    }

    @Override
    public Result register(String username , String password) {
        User u = userMapper.getUser(username);
        if (u == null){
            userMapper.insertuser(username ,password);
             return Result.success("");
        }else {
            return Result.error("");
        }
    }

    @Override
    public Result change(String username, String oldpassword, String newpassword) {
        User user = userMapper.getUser(username);
        if (user == null){
            return Result.error("用户不存在！");
        }
        //判断密码是否正确
        else if (!user.getPassword().equals(oldpassword)){
            return Result.error("旧密码错误！");
        }
        else {
            userMapper.change(username,newpassword);
            return Result.success("修改密码成功！");
        }
    }
}
