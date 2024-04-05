package com.tobeto.repository;

import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tobeto.entity.Log;

@Repository
public interface LogRepository extends JpaRepository<Log, UUID> {
	void deleteByEmail(String email);

	Optional<Log> findByEmail(String email);
}