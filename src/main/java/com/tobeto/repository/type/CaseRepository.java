package com.tobeto.repository.type;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tobeto.entity.type.DesktopCase;

@Repository
public interface CaseRepository extends JpaRepository<DesktopCase, Integer> {
	Optional<DesktopCase> findById(int id);
}