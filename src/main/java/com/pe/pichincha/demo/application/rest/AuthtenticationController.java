package com.pe.pichincha.demo.application.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pe.pichincha.demo.application.request.AuthLogin;
import com.pe.pichincha.demo.application.request.AuthSignUp;
import com.pe.pichincha.demo.application.response.AuthResponse;
import com.pe.pichincha.demo.application.response.ErrorResponse;
import com.pe.pichincha.demo.domain.service.IUserService;
import com.pe.pichincha.demo.infrastructure.security.service.MyUserDetailsService;
import com.pe.pichincha.demo.infrastructure.security.util.JwtUtil;

@RestController
@RequestMapping(path = "api/v1/auth")
public class AuthtenticationController {

	@Autowired
	private IUserService authenticationService;

	@Autowired
	private AuthenticationManager authenticationManager;

	@Autowired
	private JwtUtil jwtUtil;

	@Autowired
	private MyUserDetailsService myUserDetailsService;

	@GetMapping("/public")
	public String home() {
		return "Welcome!";
	}

	@PostMapping("/signup")
	public ResponseEntity<?> signUp(@RequestBody AuthSignUp authSignUp) {
		authenticationService.create(authSignUp);
		return ResponseEntity.ok("User successfully registered");
	}

	@PostMapping(value = "/login")
	public ResponseEntity<?> login(@RequestBody AuthLogin authLogin) throws Exception {
		try {
			authenticationManager.authenticate(
					new UsernamePasswordAuthenticationToken(authLogin.getUsername(), authLogin.getPassword()));
			final UserDetails userDetails = myUserDetailsService.loadUserByUsername(authLogin.getUsername());
			final String token = jwtUtil.createToken(userDetails);

			return ResponseEntity.ok(new AuthResponse(token));
		} catch (BadCredentialsException e) {
			ErrorResponse errorResponse = new ErrorResponse(HttpStatus.BAD_REQUEST, "Invalid username or password");
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorResponse);
		} catch (Exception e) {
			ErrorResponse errorResponse = new ErrorResponse(HttpStatus.BAD_REQUEST, e.getMessage());
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorResponse);
		}
	}

}
