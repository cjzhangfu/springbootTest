package com.ifeng.soft.test;

import com.ifeng.soft.application.Application;
import com.ifeng.soft.bean.User;
import com.ifeng.soft.mapper.UserMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = Application.class)
public class UserMapperTest {
    @Autowired
    UserMapper mapper;
    @Test
    public void testFindAll(){
       List<User> list = mapper.getAll();
        System.out.println(list.get(0).getNickName());
    }
}
