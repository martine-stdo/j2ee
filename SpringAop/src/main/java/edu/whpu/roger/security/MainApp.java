package edu.whpu.roger.security;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainApp {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("spring-security.xml");

        UserService userService = context.getBean(UserService.class);
        VipService vipService = context.getBean(VipService.class);

        userService.addUser("Asuka");
        userService.updateUser("Rei");
        userService.deleteUser("Shinji");
        userService.findUser("Misato");

        vipService.addVip("碇 シンジ");
        vipService.updateVip("綾波 レイ");
        vipService.deleteVip("惣流・アスカ・ラングレー");
        vipService.findVip("渚 カヲル");
    }
}
