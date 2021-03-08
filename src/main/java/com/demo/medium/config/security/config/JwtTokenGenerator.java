package com.demo.medium.config.security.config;

import java.util.Calendar;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

import com.demo.medium.config.security.model.TokenResponse;
import com.demo.medium.model.entity.Employee;
import com.nimbusds.jose.JOSEException;
import com.nimbusds.jose.JWSAlgorithm;
import com.nimbusds.jose.JWSHeader;
import com.nimbusds.jose.JWSSigner;
import com.nimbusds.jose.crypto.RSASSASigner;
import com.nimbusds.jose.jwk.JWK;
import com.nimbusds.jose.jwk.RSAKey;
import com.nimbusds.jwt.JWTClaimsSet;
import com.nimbusds.jwt.SignedJWT;

@Configuration
public class JwtTokenGenerator {
	public static class ClaimSet {

		public static final String ROLE_CLAIM = "role";

	}
	
	@Autowired
	private JWK jwk;
	@Autowired
	private RSAKey rsaPrivateKey;
	
	public TokenResponse generateToken(Employee user) {
		Calendar expirationDate = Calendar.getInstance();
		expirationDate.add(Calendar.DATE, 1);
		
		JWTClaimsSet claimsSet = new JWTClaimsSet.Builder()
				.subject(user.getUsername())
				.issuer("enhaa")
				.issueTime(new Date())
				.expirationTime(expirationDate.getTime())
				.claim(ClaimSet.ROLE_CLAIM, user.getPosition().getCode())
				.build();
		
		SignedJWT signedJWT = new SignedJWT(new JWSHeader.Builder(JWSAlgorithm.RS256).jwk(jwk).build(), claimsSet);
		
		try {
			JWSSigner signer = new RSASSASigner(rsaPrivateKey);
			signedJWT.sign(signer);
		} catch (JOSEException e) {
			e.printStackTrace();
		}
		
		String token = signedJWT.serialize();		
		TokenResponse response = new TokenResponse(token, expirationDate.getTimeInMillis());
		
		return response;
	}
}
