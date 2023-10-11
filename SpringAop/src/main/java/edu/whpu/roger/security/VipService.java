package edu.whpu.roger.security;

import org.springframework.stereotype.Component;

@Component
public class VipService {
    public void addVip(String username) {
        // 添加VIP用户的实际操作
        System.out.println("VIP用户 " + username + " 已添加");
    }

    public void updateVip(String username) {
        // 更新VIP用户的实际操作
        System.out.println("VIP用户 " + username + " 已更新");
    }

    public void deleteVip(String username) {
        // 删除VIP用户的实际操作
        System.out.println("VIP用户 " + username + " 已删除");
    }

    public void findVip(String username) {
        // 查询VIP用户的实际操作
        System.out.println("查找VIP用户 " + username);
    }
}
