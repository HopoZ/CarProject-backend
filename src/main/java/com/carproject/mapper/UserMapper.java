package com.carproject.mapper;

import com.carproject.pojo.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper {
    User login(String carNumber, String password);
    void register(User user);
    User getUser(String carNumber);
}
