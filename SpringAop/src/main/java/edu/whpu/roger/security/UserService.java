package edu.whpu.roger.security;

import org.springframework.stereotype.Component;

@Component
public class UserService {


    public void addUser(String username) {
        // 添加用户的实际操作
        System.out.println("用户 " + username + " 已添加");
    }

    public void updateUser(String username) {
        // 更新用户的实际操作
        System.out.println("用户 " + username + " 已更新");
    }

    public void deleteUser(String username) {
        // 删除用户的实际操作
        System.out.println("用户 " + username + " 已删除");
    }

    public void findUser(String username) {
        // 查询用户的实际操作
        System.out.println("查找用户 " + username);
    }
}

