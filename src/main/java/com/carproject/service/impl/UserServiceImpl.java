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
        return userMapper.login(user);
    }

    @Override
    public User register(User user) {
        return userMapper.register(user);
    }
}
