package com.tobeto.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tobeto.entity.Gpu;

@Repository

	public interface GpuRepository extends JpaRepository<Gpu,Integer> {
		Optional<Gpu> findById(int id);
}

