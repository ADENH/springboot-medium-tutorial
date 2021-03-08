package com.demo.medium.config.security.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demo.medium.config.security.model.TokenResponse;
import com.demo.medium.config.security.model.UsernamePasswordRequest;
import com.demo.medium.config.security.service.TokenService;

@RestController
@RequestMapping("/auth")
public class TokenController {

	@Autowired
	private TokenService tokenService;
	
	@PostMapping("/token")
	public TokenResponse login(@RequestBody UsernamePasswordRequest usernamePasswordRequest) {
		return tokenService.createToken(usernamePasswordRequest);
	}
	
}
