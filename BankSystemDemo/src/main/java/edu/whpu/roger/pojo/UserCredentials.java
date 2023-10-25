package edu.whpu.roger.pojo;

public class UserCredentials {
    private String username;  // 用户名
    private String password;  // 密码

    // 无参构造函数
    public UserCredentials() {
    }

    // 带参构造函数
    public UserCredentials(String username, String password) {
        this.username = username;
        this.password = password;
    }

    // 获取用户名
    public String getUsername() {
        return username;
    }

    // 设置用户名
    public void setUsername(String username) {
        this.username = username;
    }

    // 获取密码
    public String getPassword() {
        return password;
    }

    // 设置密码
    public void setPassword(String password) {
        this.password = password;
    }
}
