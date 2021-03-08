package com.demo.medium.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.demo.medium.dto.AccountDto;
import com.demo.medium.model.entity.Employee;
import com.demo.medium.service.AccountService;

@RestController
@RequestMapping("/account")
public class AccountController {

	@Autowired
	AccountService accountService;
	
	@GetMapping("/{username}")
	public Employee getEmployeeByUSername(@RequestParam String username) {
		return accountService.getEmployeeByUsername(username);
	}
	
	@PostMapping
	public Employee saveDataEmployee(@RequestBody AccountDto accountDto) {
		return accountService.saveDataUser(accountDto);
	}
}
