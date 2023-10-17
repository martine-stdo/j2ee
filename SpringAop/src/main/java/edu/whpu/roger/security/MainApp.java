package edu.whpu.roger.security;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainApp {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("spring-security.xml");

        UserService userService = context.getBean(UserService.class);
        VipService vipService = context.getBean(VipService.class);

        userService.addUser("张三");
        userService.updateUser("里斯");
        userService.deleteUser("王五");
        userService.findUser("张麻子");

        vipService.addVip("张三");
        vipService.updateVip("李四");
        vipService.deleteVip("王五");
        vipService.findVip("黛玉");
    }
}
