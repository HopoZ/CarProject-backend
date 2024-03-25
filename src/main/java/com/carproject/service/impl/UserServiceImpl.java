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
        return userMapper.login(user.getCarNumber(),user.getPassword());
    }

    @Override
    public void register(User user) {
        userMapper.register(user);
    }

    @Override
    public User getUser(String carNumber) {
        return userMapper.getUser(carNumber);
    }
}
