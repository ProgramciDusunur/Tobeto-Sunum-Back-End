package com.tobeto.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tobeto.entity.StockAlert;

@Repository
	public interface StockAlertRepository extends JpaRepository<StockAlert, Integer> {
	
}
