package com.tobeto.service;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.log;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tobeto.entity.Employee;
import com.tobeto.entity.Log;
import com.tobeto.repository.LogRepository;

import jakarta.transaction.Transactional;
import lombok.Data;

@Service
@Data
public class LogService {
	@Autowired
	LogRepository logRepository;

	public void createLog(Log log) {
		logRepository.save(log);
	}

	public Log readLog(String email) {
		Optional<Log> log = logRepository.findByEmail(email);
		return log.orElseThrow();
	}

	public Log updatePassword(String email, String oldPassword,
			String newPassword) {
		Employee employee = readlog(email);
		if (log.getPassword().equals(oldPassword)) {
			log.setPassword(newPassword);
			createLog(log);
		}
		return employee;
	}

	@Transactional
	public void deleteEmployee(String email) {
		employeeRepository.deleteByEmail(email);
	}
}