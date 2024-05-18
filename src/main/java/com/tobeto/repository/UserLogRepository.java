package com.tobeto.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tobeto.entity.UserLog;

public interface UserLogRepository extends JpaRepository<UserLog, Integer> {
	UserLog findById(int id);

}
