package edu.whpu.roger;

import edu.whpu.roger.pojo.Account;
import edu.whpu.roger.service.AccountService;
import edu.whpu.roger.service.impl.AccountServiceImpl;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.math.BigDecimal;

import static org.junit.Assert.assertEquals;


public class BankAccountTest {
    private AccountService accountService;

    @Before
    public void setUp() {
        // 创建 Spring 应用上下文，加载配置文件
        ApplicationContext context = new ClassPathXmlApplicationContext("spring-config.xml");

        // 获取 AccountService 实例以用于测试
        accountService = context.getBean(AccountService.class);
    }

    @Test
    public void testTransfer() {
        // 定义源账户和目标账户的ID以及转账金额
        int fromAccountId = 1;
        int toAccountId = 2;
        BigDecimal transferAmount = new BigDecimal("1000.00");

        // 获取源账户和目标账户的当前余额
        Account fromAccount = accountService.getAccountById(fromAccountId);
        Account toAccount = accountService.getAccountById(toAccountId);

        BigDecimal initialBalanceFrom = fromAccount.getBalance();
        BigDecimal initialBalanceTo = toAccount.getBalance();

        // 执行转账操作
        accountService.transfer(fromAccountId, toAccountId, transferAmount);

        // 重新获取源账户和目标账户的余额
        fromAccount = accountService.getAccountById(fromAccountId);
        toAccount = accountService.getAccountById(toAccountId);

        BigDecimal finalBalanceFrom = fromAccount.getBalance();
        BigDecimal finalBalanceTo = toAccount.getBalance();

        // Assertions for the test
        // 断言测试结果，检查转账后的余额是否符合预期
        // initialBalanceFrom 减去转账金额后应等于 finalBalanceFrom
        assertEquals(initialBalanceFrom.subtract(transferAmount), finalBalanceFrom);

        // initialBalanceTo 加上转账金额后应等于 finalBalanceTo
        assertEquals(initialBalanceTo.add(transferAmount), finalBalanceTo);
    }
}
