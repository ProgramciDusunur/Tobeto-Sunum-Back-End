package com.tobeto.repository.type;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tobeto.entity.type.Motherboard;

@Repository
public interface MotherboardRepository extends JpaRepository<Motherboard, Integer> {
	Optional<Motherboard> findById(int id);
}
