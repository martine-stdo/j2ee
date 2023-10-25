package edu.whpu.roger.service.impl;

import edu.whpu.roger.mapper.AccountMapper;
import edu.whpu.roger.pojo.Account;
import edu.whpu.roger.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;

@Service
public class AccountServiceImpl implements AccountService {

    // 使用构造函数注入AccountMapper
    private final AccountMapper accountMapper;

    @Autowired
    public AccountServiceImpl(AccountMapper accountMapper) {
        this.accountMapper = accountMapper;
    }

    // 根据账户ID获取账户信息
    @Override
    public Account getAccountById(int id) {
        return accountMapper.getAccountById(id);
    }

    // 根据账户名称获取账户信息
    @Override
    public Account getAccountByAccountName(String accountName) {
        return accountMapper.getAccountByAccountName(accountName);
    }

    // 插入新的账户信息
    @Override
    public void insertAccount(Account account) {
        accountMapper.insertAccount(account);
    }

    // 更新账户余额
    @Override
    public void updateAccount(int id, BigDecimal balance) {
        accountMapper.updateAccount(id, balance);
    }

    // 删除账户信息
    @Override
    public void deleteAccount(int id) {
        accountMapper.deleteAccount(id);
    }

    // 执行资金转账，使用事务管理
    @Override
    @Transactional
    public void transfer(int fromId, int toId, BigDecimal amount) {
        Account fromAccount = getAccountById(fromId);
        Account toAccount = getAccountById(toId);

        // 检查源账户余额是否足够
        if (fromAccount.getBalance().compareTo(amount) < 0) {
            throw new RuntimeException("账号资金不足，转账失败");
        }

        // 扣除源账户余额并增加目标账户余额
        fromAccount.setBalance(fromAccount.getBalance().subtract(amount));
        toAccount.setBalance(toAccount.getBalance().add(amount));

        // 更新源账户和目标账户的余额
        updateAccount(fromId, fromAccount.getBalance());
        updateAccount(toId, toAccount.getBalance());
    }
}
