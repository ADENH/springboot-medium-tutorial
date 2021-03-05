package com.demo.medium.controller;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demo.medium.dto.AccountDto;
import com.demo.medium.model.entity.Account;
import com.demo.medium.service.AccountService;

@RestController
@RequestMapping("/user")
public class AccountController {
	
	@Autowired
	private AccountService accountService;
	
	@GetMapping("/me")
	public Principal me(Principal principal)
	{
		return principal;
	}
	
	@GetMapping("/me/info")
	public Account user(Principal principal) {
		return accountService.findByUsername(principal.getName());
	}
	
	@GetMapping("/me/info/test")
	public Account usertest() {
		return accountService.getCurrentUser();
	}
	
	@PostMapping("/")
	public Account saveUser(@RequestBody AccountDto user) {
		return accountService.add(user);
	}
}
