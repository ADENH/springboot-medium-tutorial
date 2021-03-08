package com.demo.medium.config.security.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;


import com.demo.medium.config.security.config.JwtTokenGenerator;
import com.demo.medium.config.security.model.TokenResponse;
import com.demo.medium.config.security.model.UsernamePasswordRequest;
import com.demo.medium.config.security.service.TokenService;
import com.demo.medium.model.CurrentPrincipal;

@Service
public class TokenServiceImpl implements TokenService{

	@Autowired
	private AuthenticationManager authenticationManager;
	@Autowired
	private JwtTokenGenerator tokenGenerator;
	
	@Override
	public TokenResponse createToken(UsernamePasswordRequest usernamePasswordRequest) {
		UsernamePasswordAuthenticationToken uPas = new UsernamePasswordAuthenticationToken(usernamePasswordRequest.getUsername(), usernamePasswordRequest.getPassword());
		Authentication auth = authenticationManager.authenticate(uPas);
		CurrentPrincipal principal = (CurrentPrincipal) auth.getPrincipal();
		
		return tokenGenerator.generateToken(principal.getAccount());
	}

}
