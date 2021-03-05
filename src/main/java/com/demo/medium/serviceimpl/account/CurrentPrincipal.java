package com.demo.medium.serviceimpl.account;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.demo.medium.model.entity.Account;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class CurrentPrincipal implements UserDetails {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Account account;
	
	public Account getAccount ()
	{
		return account;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		List<GrantedAuthority> roles = new ArrayList<>();
		if (account.getPosition() != null) {
			roles.add(new SimpleGrantedAuthority(account.getPosition().getCode()));
		}
		return roles;
	}

	@Override
	public String getPassword() {
		return account.getPassword();
	}

	@Override
	public String getUsername() {
		return account.getUsername();
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}

}
