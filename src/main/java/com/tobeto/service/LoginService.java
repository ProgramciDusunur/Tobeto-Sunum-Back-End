package com.tobeto.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tobeto.entity.Employee;
import com.tobeto.repository.LoginRepository;

@Service
public class LoginService {
	@Autowired
	private LoginRepository loginRepository;
	@Autowired
	private TokenService tokenService;

	public String login(String employeeEmail, String employeePassword) {
		String token;
		Optional<Employee> employee = loginRepository.findByEmail(employeeEmail);
		if (employee.isPresent() && employee.get().getPassword().equals(employeePassword)) {
			System.out.println("Admin: " + employee.get().getRole());
			token = tokenService.createToken(employee.get());
			System.out.println("Username exist and passwords are equal");
			return token;
		} else {
			System.out.println("Username not found or password wrong");
			return null;
		}
	}

}
