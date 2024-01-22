package com.pe.pichincha.demo.infrastructure.security.util;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Component
public class JwtUtil {

	@Value("${token.secret}")
	private String secret;
	@Value("${token.time}")
	private long accessTokenValidity;

	public Claims getClaimContentFromToken(String token) {
		return Jwts.parser().setSigningKey(secret).parseClaimsJws(token).getBody();
	}

	public String getUsernameFromToken(String token) {
		return getClaimContentFromToken(token).getSubject();
	}

	public Date getTimeExpirationFromToken(String token) {
		return getClaimContentFromToken(token).getExpiration();
	}

	public Boolean isTokenExpired(String token) {
		return getTimeExpirationFromToken(token).before(new Date());
	}

	public String buildToken(Map<String, Object> payload, String subject) {
		return Jwts.builder().setClaims(payload).setSubject(subject).setIssuedAt(new Date(System.currentTimeMillis()))
				.setExpiration(new Date(System.currentTimeMillis() + accessTokenValidity))
				.signWith(SignatureAlgorithm.HS512, secret).compact();
	}

	public String createToken(UserDetails userDetails) {
		Map<String, Object> claims = new HashMap<>();
		return buildToken(claims, userDetails.getUsername());
	}

	public Boolean validateToken(String token, UserDetails userDetails) {
		final String username = getUsernameFromToken(token);
		return (username.equals(userDetails.getUsername()) && !isTokenExpired(token));
	}
}
