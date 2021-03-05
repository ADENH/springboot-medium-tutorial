package com.demo.medium.serviceimpl.account;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.demo.medium.model.entity.Account;
import com.demo.medium.service.AccountService;

@Service
public class CurrentAccountDetailsServiceImpl implements UserDetailsService {
	
	@Autowired
	AccountService accountService;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Account user = accountService.findByUsername(username);
		
		if (user == null)
			throw new UsernameNotFoundException("username "+username+" not found");

		return new CurrentPrincipal(user);
	}

}
