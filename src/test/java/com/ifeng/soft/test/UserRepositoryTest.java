package com.ifeng.soft.test;

import com.ifeng.soft.Application;
import com.ifeng.soft.bean.User;
import com.ifeng.soft.dao.UserRepository;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.text.DateFormat;
import java.util.Date;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = Application.class)
public class UserRepositoryTest {
    @Autowired
    public UserRepository userRepository;
    @Test
    public void test(){
        Date date = new Date();
        DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG);
        String formattedDate = dateFormat.format(date);

        userRepository.save(new User("aa1", "aa", "aa@126.com", "aa123456", formattedDate));
        Assert.assertEquals(9,userRepository.findAll().size());
        Assert.assertEquals("aa123456", userRepository.findByUserNameOrEmails("aa", "aa@126.com").getNickName());
    }
}
