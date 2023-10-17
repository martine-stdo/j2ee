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
    private final AccountMapper accountMapper;

    @Autowired
    public AccountServiceImpl(AccountMapper accountMapper) {
        this.accountMapper = accountMapper;
    }

    @Override
    public Account getAccountById(int id) {
        return accountMapper.getAccountById(id);
    }

    @Override
    public Account getAccountByAccountName(String accountName) {
        return accountMapper.getAccountByAccountName(accountName);
    }

    @Override
    public void insertAccount(Account account) {
        accountMapper.insertAccount(account);
    }

    @Override
    public void updateAccount(int id, BigDecimal balance) {
        accountMapper.updateAccount(id, balance);
    }

    @Override
    public void deleteAccount(int id) {
        accountMapper.deleteAccount(id);
    }

    @Override
    @Transactional
    public void transfer(int fromId, int toId, BigDecimal amount) {
        Account fromAccount = getAccountById(fromId);
        Account toAccount = getAccountById(toId);

        if (fromAccount.getBalance().compareTo(amount) < 0) {
            throw new RuntimeException("账号资金不足，转账失败");
        }

        fromAccount.setBalance(fromAccount.getBalance().subtract(amount));
        toAccount.setBalance(toAccount.getBalance().add(amount));

        updateAccount(fromId, fromAccount.getBalance());
        updateAccount(toId, toAccount.getBalance());
    }
}
