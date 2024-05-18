package com.tobeto.service;

import java.util.Date;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.tobeto.entity.Employee;
import com.tobeto.entity.UserLog;
import com.tobeto.repository.LoginRepository;

@Service
public class LoginService {
	@Autowired
	private LoginRepository loginRepository;
	@Autowired
	private TokenService tokenService;

	@Autowired
	private PasswordEncoder passwordEncoder;
	@Autowired
	private UserLogService userLogService;

	public String login(String employeeEmail, String employeePassword) {
		String token;
		UserLog log = new UserLog();
		Optional<Employee> employee = loginRepository.findByEmail(employeeEmail);
		if (employee.isPresent() && passwordEncoder.matches(employeePassword, employee.get().getPassword())) {

			log.setUserId(employee.get().getId());
			log.setTransactionCode(UUID.randomUUID());
			log.setTransactionDate(new Date());
			log.setTransactionType("LOGIN");
			log.setUser(employee.get().getName() + " " + employee.get().getSurname());
			log.setTransactionDetail("User logged in successfully");
			userLogService.createUserLog(log);
			token = tokenService.createToken(employee.get());
			return token;
		}
		return null;
	}
}
