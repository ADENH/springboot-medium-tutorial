package com.demo.medium.model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.demo.medium.model.entity.Employee;

public class CurrentPrincipal implements UserDetails {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -5762158177910016816L;
	private Employee employee;
	
	public CurrentPrincipal(Employee employee) {
		this.employee = employee;
	}

	public Employee getAccount() {
		return employee;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		List<GrantedAuthority> roles = new ArrayList<>();
		if (employee.getPosition() != null)
			roles.add(new SimpleGrantedAuthority(employee.getPosition().getCode()));

		return roles;
	}

	@Override
	public String getPassword() {
		return employee.getPassword();
	}

	@Override
	public String getUsername() {
		return employee.getUsername();
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
