package com.ifeng.soft.dao;

import com.ifeng.soft.bean.User;
import org.springframework.data.jpa.repository.JpaRepository;


public interface UserRepository  extends JpaRepository<User,Long>{
    User findByUserName(String userName);
    User findByUserNameOrEmails(String username, String emails);


}
