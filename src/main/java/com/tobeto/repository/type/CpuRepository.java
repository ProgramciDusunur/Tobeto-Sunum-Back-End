package com.tobeto.repository.type;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tobeto.entity.type.Cpu;

@Repository
public interface CpuRepository extends JpaRepository<Cpu, Integer> {
	Optional<Cpu> findById(int id);
}
