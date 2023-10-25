package edu.whpu.roger.mapper;

import edu.whpu.roger.pojo.Account;
import org.apache.ibatis.annotations.*;
import java.math.BigDecimal;

@Mapper
public interface AccountMapper {

    // 根据账户ID获取账户信息
    Account getAccountById(int id);

    // 根据账户名称获取账户信息（自定义方法）
    Account getAccountByAccountName(String accountName);

    // 插入新的账户信息到数据库
    void insertAccount(Account account);

    // 根据账户ID更新账户余额
    void updateAccount(@Param("id") int id, @Param("balance") BigDecimal balance);

    // 根据账户ID删除账户信息
    void deleteAccount(int id);
}
