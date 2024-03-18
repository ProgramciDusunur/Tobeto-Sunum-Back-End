package com.tobeto.repository.type;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tobeto.entity.type.CpuCooler;

@Repository
public interface CpuCoolerRepository extends JpaRepository<CpuCooler, Integer> {
	Optional<CpuCooler> findById(int id);
}
