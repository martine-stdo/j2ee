package edu.whpu.roger.service.impl;

import edu.whpu.roger.mapper.UserMapper;
import edu.whpu.roger.pojo.Account;
import edu.whpu.roger.pojo.User;
import edu.whpu.roger.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    // 使用构造函数注入UserMapper
    private final UserMapper userMapper;

    @Autowired
    public UserServiceImpl(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    // 用户登录验证
    @Override
    public User login(String username, String password) {
        if (username != null && !username.isEmpty() && password != null && !password.isEmpty()) {
            // 调用UserMapper进行身份验证
            return userMapper.getUserByUsernameAndPassword(username, password);
        }
        return null; // 身份验证失败
    }

    // 用户注册
    @Override
    public String register(String username, String password) {
        if (username != null && !username.isEmpty() && password != null && !password.isEmpty()) {
            // 检查用户是否已经存在
            if (userMapper.getUserByUsername(username) != null) {
                return "user_already_exists";
            } else {
                // 往数据库中插入用户
                userMapper.insertUser(username, password);
                return "success";
            }
        } else {
            return "invalid_input";
        }
    }

    // 根据用户名获取用户信息
    @Override
    public User getUserByUsername(String username) {
        return userMapper.getUserByUsername(username);
    }

    // 根据用户ID获取账户信息
    @Override
    public Account getAccountByUserId(int id) {
        return userMapper.getAccountByUserId(id);
    }
}
