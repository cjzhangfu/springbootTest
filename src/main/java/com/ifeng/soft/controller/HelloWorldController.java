package com.ifeng.soft.controller;

import com.ifeng.soft.bean.User;
import com.ifeng.soft.dao.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import javax.xml.bind.ValidationEvent;
import java.util.UUID;

@RestController
public class HelloWorldController {
    @Autowired
    UserRepository userRepository;

    @RequestMapping(value = "hello",method = RequestMethod.GET)
    public String Hello(){
    return "Hello World! zhangfu" ;
    }

    @RequestMapping(value = "getUser",method = RequestMethod.GET)
    @Cacheable(value = "user1")
    public User getUser(){
        User user=userRepository.findByUserName("aa");
        System.out.println("若下面没出现“无缓存的时候调用”字样且能打印出数据表示测试成功");
        return user;
    }

    @RequestMapping(value = "uid")
    public String uid(HttpSession session){
        UUID uid = (UUID) session.getAttribute("uid");
        if(uid==null){
            uid = UUID.randomUUID();
        }
        session.setAttribute("uid",uid);
        return session.getId();
    }
}
