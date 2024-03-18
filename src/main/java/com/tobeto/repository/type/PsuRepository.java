package com.tobeto.repository.type;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tobeto.entity.type.Psu;

@Repository
public interface PsuRepository extends JpaRepository<Psu, Integer> {
	Optional<Psu> findById(int id);
}
