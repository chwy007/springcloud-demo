package com.yujizi.web;

import com.yujizi.pojo.User;
import com.yujizi.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("user")
public class UserController {
    @Autowired
    private UserService userService;
    @GetMapping("{id}")
    public User queryByid(@PathVariable Long id){
        User user = userService.queryById(id);
        return user;
    }
}
