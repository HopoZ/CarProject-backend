package com.carproject.service.impl;

import com.carproject.mapper.UserMapper;
import com.carproject.pojo.User;
import com.carproject.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;

    @Override
    public User login(User user) {
        User u = userMapper.login(user);
        return u;
    }
}
