package com.demo.medium.config.security.service;

import com.demo.medium.config.security.model.TokenResponse;
import com.demo.medium.config.security.model.UsernamePasswordRequest;

public interface TokenService {
	TokenResponse createToken(UsernamePasswordRequest usernamePasswordRequest);
}
