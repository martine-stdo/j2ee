package edu.whpu.roger.mapper;

import edu.whpu.roger.pojo.Account;
import org.apache.ibatis.annotations.*;
import java.math.BigDecimal;
@Mapper
public interface AccountMapper {
    Account getAccountById(int id);
    Account getAccountByAccountName(String accountName); // 添加根据账户名称查询的方法

    void insertAccount(Account account);

    void updateAccount(@Param("id") int id, @Param("balance") BigDecimal balance);

    void deleteAccount(int id);
}
