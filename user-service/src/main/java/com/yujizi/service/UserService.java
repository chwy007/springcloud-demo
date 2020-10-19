package com.yujizi.service;

import com.yujizi.mapper.UserMapper;
import com.yujizi.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserMapper userMapper;
    public User queryById(Long id){
//        try {
//            Thread.sleep(2000L);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }

        if(id%2==0){
            throw new RuntimeException("");
        }

        User user = userMapper.selectByPrimaryKey(id);
        return user;
    }
}
