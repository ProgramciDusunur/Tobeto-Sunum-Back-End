package com.tobeto.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tobeto.dto.login.LoginRequestDTO;
import com.tobeto.dto.login.LoginResponseDTO;
import com.tobeto.service.LoginService;

@RestController
@RequestMapping("/api/v1/login")
public class LoginController {
	@Autowired
	private LoginService loginService;

	@PostMapping()
	public ResponseEntity<LoginResponseDTO> login(@RequestBody LoginRequestDTO dto) {
		LoginResponseDTO responseDTO = new LoginResponseDTO();
		String token = loginService.login(dto.getEmail(), dto.getPassword());
		System.out.println(dto);
		if (token != null) {
			responseDTO.setToken(token);
			return ResponseEntity.ok().body(responseDTO);
		} else {
			return ResponseEntity.status(HttpStatus.FORBIDDEN).build();
		}

	}
}