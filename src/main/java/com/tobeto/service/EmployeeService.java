package com.tobeto.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.tobeto.entity.Employee;
import com.tobeto.repository.EmployeeRepository;

import jakarta.transaction.Transactional;
import lombok.Data;

@Service
@Data
public class EmployeeService {
	@Autowired
	EmployeeRepository employeeRepository;

	@Autowired
	private PasswordEncoder passwordEncoder;

	public void createEmployee(Employee employee) {
		employee.setPassword(passwordEncoder.encode(employee.getPassword()));
		employeeRepository.save(employee);
	}

	public Employee readEmployee(String email) {
		Optional<Employee> employee = employeeRepository.findByEmail(email);
		return employee.orElseThrow();
	}

	public Employee updatePassword(String email, String oldPassword, String newPassword) {
		Employee employee = readEmployee(email);
		if (passwordEncoder.matches(oldPassword, employee.getPassword())) {
			employee.setPassword(passwordEncoder.encode(newPassword));
			employeeRepository.save(employee);
		}
		return employee;
	}

	public List<Employee> getAllEmployees() {
		return employeeRepository.findAll();
	}

	@Transactional
	public void deleteEmployee(String email) {
		employeeRepository.deleteByEmail(email);
	}
}