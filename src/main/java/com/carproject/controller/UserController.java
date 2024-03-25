package com.carproject.controller;

import com.carproject.pojo.User;
import com.carproject.service.UserService;
import com.carproject.util.JWTUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    /**
     * 登录
     * @param user 用户信息
     * @return 结果
     */
    @PostMapping("/login")
    public Map<String, Object> login(@RequestBody  User user) {

        Map<String, Object> map = new HashMap<>();

        try {
            User userDB = userService.login(user);
            Map<String, String> payload = new HashMap<>();
            //用户登录成功后的信息放入payload
            payload.put("carNumber", userDB.getCarNumber());
            //生成JWT令牌
            String token = JWTUtils.getToken(payload);
            map.put("state", true);
            map.put("token", token);
            map.put("msg", "认证成功");
        } catch (Exception e) {
            map.put("state", false);
            map.put("msg", e.getMessage());
        }
        return map;
    }

    @PostMapping("/user/test")
    public Map<String, Object> test(String token) {
        Map<String, Object> map = new HashMap<>();
        map.put("state", true);
        map.put("msg", "请求成功");
        return map;
    }

    /**
     * 注册
     * @param newUser 用户信息
     * @return 结果
     */
    @PostMapping("/register")
    public Map<String, Object> register(@RequestBody User newUser){
        Map<String, Object> map = new HashMap<>();

        try {
            User userDB = userService.register(newUser);

            map.put("state", true);
            map.put("carNumber", userDB.getCarNumber());
            map.put("password", userDB.getPassword());
            map.put("msg", "注册成功");
        } catch (Exception e) {
            map.put("state", false);
            map.put("msg", e.getMessage());
        }
        return map;
    }

}
