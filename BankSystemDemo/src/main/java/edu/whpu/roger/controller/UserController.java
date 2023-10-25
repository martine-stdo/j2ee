package edu.whpu.roger.controller;

import edu.whpu.roger.pojo.Account;
import edu.whpu.roger.pojo.UserCredentials;
import edu.whpu.roger.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.fasterxml.jackson.databind.ObjectMapper;
import edu.whpu.roger.pojo.User;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    // 处理用户登录请求
    @PostMapping("/login")
    public Map<String, String> login(@RequestBody UserCredentials userCredentials) {
        Map<String, String> map = new HashMap<>();
        String username = userCredentials.getUsername();
        String password = userCredentials.getPassword();

        // 创建一个ObjectMapper对象，用于处理JSON数据
        ObjectMapper objectMapper = new ObjectMapper();

        // 检查用户名和密码是否非空
        if (username != null && !username.isEmpty() && password != null && !password.isEmpty()) {
            // 调用UserService中的login方法，尝试用户登录
            User user = userService.login(username, password);
            if (user != null) {
                map.put("error_message", "success");
            } else {
                map.put("error_message", "failed");
            }
        } else {
            map.put("error_message", "invalid_input");
        }

        return map;
    }

    // 处理用户注册请求
    @PostMapping("/register")
    public Map<String, String> register(@RequestBody UserCredentials userCredentials) {
        Map<String, String> map = new HashMap<>();
        String username = userCredentials.getUsername();
        String password = userCredentials.getPassword();

        // 调用UserService中的register方法，尝试用户注册
        String result = userService.register(username, password);

        if ("success".equals(result)) {
            map.put("error_message", "success");
        } else if ("user_already_exists".equals(result)) {
            map.put("error_message", "user_already_exists");
        } else {
            map.put("error_message", "invalid_input");
        }

        return map;
    }

    // 获取用户信息
    @PostMapping("/getInfo")
    public Map<String, String> getInfo(@RequestBody Map<String, String> requestData) {
        Map<String, String> map = new HashMap<>();
        String username = requestData.get("username");
        if (username != null && !username.isEmpty()) {
            // 通过用户名获取用户信息
            User user = userService.getUserByUsername(username);
            if (user != null) {
                // 获取用户的账户信息和余额
                Account account = userService.getAccountByUserId(user.getId());
                map.put("fromAccount", account.getAccount());
                map.put("balance", account.getBalance().toString());
            } else {
                map.put("error_message", "failed");
            }
        } else {
            map.put("error_message", "invalid_input");
        }
        return map;
    }
}
