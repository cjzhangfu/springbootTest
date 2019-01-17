package com.ifeng.soft.mapper;

import com.ifeng.soft.bean.User;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface UserMapper {
    @Select("select * from user")
    @Results({
            @Result(property = "userName",column = "user_name"),
            @Result(property = "emails",column = "emails"),
            @Result(property = "nickName",column = "nick_name"),
            @Result(property = "passWord",column = "pass_word"),
            @Result(property = "regTime",column = "reg_time"),
            @Result(property = "id",column = "id")
    })
    List<User> getAll();
    @Delete("delete from user where id=#{id}")
    void delete(Long id);
}
