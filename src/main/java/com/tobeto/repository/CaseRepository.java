package com.tobeto.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tobeto.entity.Case;

@Repository
public interface CaseRepository extends JpaRepository<Case,Integer> {
	Optional<Case> findById(int id);
}