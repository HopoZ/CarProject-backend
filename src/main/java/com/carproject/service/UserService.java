package com.carproject.service;

import com.carproject.pojo.User;

public interface UserService {

    User login (User user);
    void register (User user);
    User getUser (String carNumber);

}
