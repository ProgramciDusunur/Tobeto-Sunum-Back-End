package com.tobeto.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import com.tobeto.entity.Ram;

@Repository
public interface RamRepository extends JpaRepository<Ram,Integer> {
	Optional<Ram> findById(int id);
}
