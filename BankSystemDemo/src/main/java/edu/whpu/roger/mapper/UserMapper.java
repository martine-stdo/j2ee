package edu.whpu.roger.mapper;

import edu.whpu.roger.pojo.Account;
import edu.whpu.roger.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface UserMapper {

    // 根据用户名和密码查询用户信息
    User getUserByUsernameAndPassword(@Param("username") String username, @Param("password") String password);

    // 根据用户ID获取账户信息
    Account getAccountByUserId(@Param("id") int id);

    // 通过用户名获取用户ID
    int getUserIdByUsername(@Param("username") String username);

    // 通过用户名获取用户信息
    User getUserByUsername(@Param("username") String username);

    // 插入新用户信息
    void insertUser(@Param("username") String username, @Param("password") String password);
}
