package com.tobeto.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tobeto.entity.Stock;

@Repository
public interface StockRepository extends JpaRepository<Stock, Integer> {
	Optional<Stock> findById(int id);
}
