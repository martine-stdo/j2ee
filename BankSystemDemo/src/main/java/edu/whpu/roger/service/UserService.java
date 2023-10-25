package edu.whpu.roger.service;

import edu.whpu.roger.pojo.Account;
import edu.whpu.roger.pojo.User;

public interface UserService {
    User login(String username, String password);

    String register(String username, String password);

    User getUserByUsername(String username);

    Account getAccountByUserId(int id);

}
