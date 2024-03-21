package com.tobeto.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tobeto.entity.StockAlert;

import com.tobeto.repository.StockAlertRepository;

import jakarta.transaction.Transactional;
import lombok.Data;


@Service
@Data
public class StockAlertService {
	@Autowired
	StockAlertRepository stockAlertRepository;

	public void createStockAlert(StockAlert stockAlert) {
		stockAlertRepository.save(stockAlert);
	}

	public StockAlert readStockAlert(int id) {
		Optional<StockAlert> stockAlert = stockAlertRepository.findById(id);
		return stockAlert.orElseThrow();
	}

	public void updateStockAlert() {
		
	}

	@Transactional
	public void deleteStockAlert(int id) {
		stockAlertRepository.deleteById(id);
	}

}