package com.carproject.controller;

import com.carproject.pojo.User;
import com.carproject.service.UserService;
import com.carproject.util.JWTUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    /**
     * 登录
     *
     * @param user 用户信息
     * @return 结果
     */
    @PostMapping("/login")
    @CrossOrigin(origins = "http://localhost:8080")
    public Map<String, Object> login(@RequestBody User user) {

        Map<String, Object> map = new HashMap<>();

        try {
            User userDB = userService.login(user);
            if (userDB != null) {
                Map<String, String> payload = new HashMap<>();
                //用户登录成功后的信息放入payload
                payload.put("carNumber", user.getCarNumber());
                //生成JWT令牌
                String token = JWTUtils.getToken(payload);
                map.put("state", true);
                map.put("token", token);
                map.put("msg", "认证成功");
            } else {
                map.put("state", false);
                map.put("msg", "用户名或密码错误");
            }
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
     *
     * @param newUser 用户信息
     * @return 结果
     */
    @PostMapping("/register")
    @CrossOrigin(origins = "http://localhost:8080")
    public Map<String, Object> register(@RequestBody User newUser) {
        Map<String, Object> map = new HashMap<>();
        if (userService.getUser(newUser.getCarNumber()) != null) {
            map.put("state", false);
            map.put("msg", "该车已注册");
            return map;
        }

        try {
            userService.register(newUser);

            map.put("state", true);
            map.put("carNumber", newUser.getCarNumber());
            map.put("password", newUser.getPassword());
            map.put("msg", "注册成功");
        } catch (Exception e) {
            map.put("state", false);
            map.put("msg", e.getMessage());
        }
        return map;
    }

}
