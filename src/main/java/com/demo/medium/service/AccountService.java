package com.demo.medium.service;

import java.util.List;

import com.demo.medium.dto.AccountDto;
import com.demo.medium.model.entity.Account;

public interface AccountService {
    Account findByUsername(String username);
    List<Account> findAll();
    Account add(AccountDto user);
    Account getCurrentUser();
}
