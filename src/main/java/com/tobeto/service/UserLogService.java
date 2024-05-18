package com.tobeto.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tobeto.entity.UserLog;
import com.tobeto.repository.UserLogRepository;

import lombok.Data;

@Service
@Data
public class UserLogService {
	@Autowired
	private UserLogRepository userLogRepository;

	public void createUserLog(UserLog userLog) {
		userLogRepository.save(userLog);
	}

	public UserLog readUserLog(int id) {
		return userLogRepository.findById(id);
	}

	public void updateUserLog(UserLog userLog, int id) {
		UserLog currentUserLog = readUserLog(id);
		currentUserLog = userLog;
		createUserLog(currentUserLog);
	}

	public List<UserLog> getAllUserLog() {
		return userLogRepository.findAll();
	}

}
