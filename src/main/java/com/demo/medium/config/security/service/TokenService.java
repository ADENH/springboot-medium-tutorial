package com.demo.medium.config.security.service;

import com.demo.medium.config.security.model.TokenResponse;
import com.demo.medium.config.security.model.UsernamePasswordRequest;

/**
 * Created by Spring Tool Suite.
 * @author Ade Hidayat
 * Date: Mar 18, 2021
 * Time: 11:47:07 AM
 */
public interface TokenService {
	/**
	 * @param usernamePasswordRequest
	 * @return TokenResponse
	 */
	TokenResponse createToken(UsernamePasswordRequest usernamePasswordRequest);
}
