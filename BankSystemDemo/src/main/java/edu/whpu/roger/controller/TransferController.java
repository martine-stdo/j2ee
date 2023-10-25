package edu.whpu.roger.controller;

import edu.whpu.roger.pojo.Account;
import edu.whpu.roger.service.AccountService;
import edu.whpu.roger.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/transfer")
public class TransferController {

    // 使用@Autowired注解进行依赖注入，将AccountService注入到TransferController中
    @Autowired
    private AccountService accountService;

    // 使用POST请求映射到"/transfer/transferFunds"路径
    @PostMapping("/transferFunds")
    public Map<String, String> transferFunds(@RequestBody Map<String, Object> transferData) {
        // 创建一个Map对象，用于存储响应数据
        Map<String, String> response = new HashMap<>();

        // 获取源账户名、目标账户名和转账金额
        String fromAccountName = (String) transferData.get("fromAccountName");
        String toAccountName = (String) transferData.get("toAccountName");
        BigDecimal transferAmount = new BigDecimal(transferData.get("amount").toString());

        // 查询源账户和目标账户
        Account fromAccount = accountService.getAccountByAccountName(fromAccountName);
        Account toAccount = accountService.getAccountByAccountName(toAccountName);
        //检查源账户和目标账户是否相同

        if(fromAccountName.equals(toAccountName)){
            response.put("error_message", "源账户和目标账户不能相同");
            return response;
        }
        // 检查源账户和目标账户是否存在
        if (fromAccount == null || toAccount == null) {
            response.put("error_message", "无效的账户名");
            return response;
        }

        // 检查源账户余额是否足够
        if (fromAccount.getBalance().compareTo(transferAmount) < 0) {
            response.put("error_message", "余额不足");
            return response;
        }

        // 执行转账
        try {
            accountService.transfer(fromAccount.getId(), toAccount.getId(), transferAmount);
            response.put("error_message", "转账成功");
        } catch (Exception e) {
            response.put("error_message", "Transfer failed: " + e.getMessage());
        }

        // 返回响应数据
        return response;
    }
}
