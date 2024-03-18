package com.tobeto.repository.type;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tobeto.entity.type.Case;

@Repository
public interface CaseRepository extends JpaRepository<Case, Integer> {
	Optional<Case> findById(int id);
}