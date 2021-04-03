package com.demo.medium.config.security.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.demo.medium.model.CurrentPrincipal;
import com.demo.medium.model.entity.Employee;
import com.demo.medium.service.AccountService;


/**
 * Created by Spring Tool Suite.
 * @author Ade Hidayat
 * Date: Mar 18, 2021
 * Time: 11:29:37 AM
 */
@Service
public class CurrentUserDetailsServiceImpl implements UserDetailsService
{

	// @Autowired
	// private UserService userService;
	@Autowired
	private AccountService accountService;
	
	@Override
	public UserDetails loadUserByUsername (String username) throws UsernameNotFoundException
	{
		Employee user = accountService.getEmployeeByUsername(username);
		
		if (user == null)
			throw new UsernameNotFoundException("username "+username+" not found");

		return new CurrentPrincipal(user);
	}
}
