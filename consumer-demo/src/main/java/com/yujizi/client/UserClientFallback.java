package com.yujizi.client;

import com.yujizi.pojo.User;
import org.springframework.stereotype.Component;

@Component
public class UserClientFallback implements UserClient {
    @Override
    public User queryById(Long id) {
        User user=new User();
        user.setUsername("未知用户");
        return user;
    }
}
