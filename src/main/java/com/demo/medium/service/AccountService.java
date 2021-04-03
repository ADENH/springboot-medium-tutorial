package com.demo.medium.service;

import com.demo.medium.dto.AccountDto;
import com.demo.medium.model.entity.Employee;

/**
 * Created by Spring Tool Suite.
 * @author Ade Hidayat
 * Date: Mar 18, 2021
 * Time: 11:31:15 AM
 */
public interface AccountService {
	/**
	 * @param username
	 * @return
	 */
	Employee getEmployeeByUsername(String username);
	/**
	 * @param accountDto
	 * @return
	 */
	Employee saveDataUser(AccountDto accountDto);
}
