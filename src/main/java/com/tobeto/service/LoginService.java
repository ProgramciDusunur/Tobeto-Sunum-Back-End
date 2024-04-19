package com.tobeto.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.tobeto.entity.Employee;
import com.tobeto.repository.LoginRepository;

@Service
public class LoginService {
	@Autowired
	private LoginRepository loginRepository;
	@Autowired
	private TokenService tokenService;

	@Autowired
	private PasswordEncoder passwordEncoder;

	public String login(String employeeEmail, String employeePassword) {
		String token;
		Optional<Employee> employee = loginRepository.findByEmail(employeeEmail);
		if (employee.isPresent() && passwordEncoder.matches(employeePassword, employee.get().getPassword())) {
			token = tokenService.createToken(employee.get());
			return token;
		} else {
			return null;
		}
	}

}
