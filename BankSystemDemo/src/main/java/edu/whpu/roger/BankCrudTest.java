package edu.whpu.roger;

import edu.whpu.roger.pojo.Account;
import edu.whpu.roger.service.AccountService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.math.BigDecimal;

public class BankCrudTest {

    private AccountService accountService;

    @Before
    public void setup() {
        // 初始化 Spring 容器
        ApplicationContext context = new ClassPathXmlApplicationContext("spring-config.xml");

        // 获取 AccountService 实例
        accountService = context.getBean(AccountService.class);
    }

    @Test
    public void testCreateAccount() {
        // 创建一个新账户
        Account newAccount = new Account();
        newAccount.setAccount("NewAccount2");
        newAccount.setBalance(new BigDecimal("1000.00"));
        accountService.insertAccount(newAccount);

        // 通过ID查询账户
        Account retrievedAccount = accountService.getAccountByAccountName(newAccount.getAccount());

        // 使用JUnit的断言方法来添加成功或失败的提示信息
        Assert.assertNotNull("Failed to create account", retrievedAccount);
        Assert.assertEquals("Created account balance is incorrect", newAccount.getBalance(), retrievedAccount.getBalance());
    }

    @Test
    public void testUpdateAccount() {
        // 更新账户余额
        BigDecimal newBalance = new BigDecimal("1500.00");
        int accountId = 1; // 请替换成你要更新的账户的ID
        accountService.updateAccount(accountId, newBalance);

        // 再次查询账户，确认余额已更新
        Account updatedAccount = accountService.getAccountById(accountId);

        // 使用JUnit的断言方法来添加成功或失败的提示信息
        Assert.assertNotNull("Failed to update account balance", updatedAccount);
        Assert.assertEquals("Updated account balance is incorrect", newBalance, updatedAccount.getBalance());
    }

    @Test
    public void testDeleteAccount() {
        // 删除账户
        int accountId = 4; // 请替换成你要删除的账户的ID
        accountService.deleteAccount(accountId);

        // 查询已删除的账户，应返回null
        Account deletedAccount = accountService.getAccountById(accountId);

        // 使用JUnit的断言方法来添加成功或失败的提示信息
        Assert.assertNull("Failed to delete account", deletedAccount);
    }

}

