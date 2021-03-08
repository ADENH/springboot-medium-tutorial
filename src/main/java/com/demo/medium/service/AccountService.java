package com.demo.medium.service;

import com.demo.medium.dto.AccountDto;
import com.demo.medium.model.entity.Employee;

public interface AccountService {
	Employee getEmployeeByUsername(String username);
	Employee saveDataUser(AccountDto accountDto);
}
