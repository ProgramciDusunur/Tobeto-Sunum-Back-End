package com.tobeto.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tobeto.entity.Cpu;


@Repository
	public interface CpuRepository extends JpaRepository<Cpu,Integer> {
		Optional<Cpu> findById(int id);
}

