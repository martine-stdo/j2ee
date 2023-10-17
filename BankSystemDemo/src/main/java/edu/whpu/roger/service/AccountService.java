package edu.whpu.roger.service;

import edu.whpu.roger.pojo.Account;

import java.math.BigDecimal;

public interface AccountService {
    Account getAccountById(int id);
    Account getAccountByAccountName(String accountName); // 添加根据账户名称查询的方法

    void insertAccount(Account account);

    void updateAccount(int id, BigDecimal balance);

    void deleteAccount(int id);

    void transfer(int fromId, int toId, BigDecimal amount);
}
