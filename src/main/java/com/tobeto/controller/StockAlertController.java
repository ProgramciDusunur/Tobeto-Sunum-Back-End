package com.tobeto.controller;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.tobeto.dto.SuccessResponseDTO;
import com.tobeto.dto.alert.AddStockAlertRequestDTO;
import com.tobeto.dto.alert.AddStockAlertResponseDTO;
import com.tobeto.dto.alert.DeleteStockAlertRequestDTO;
import com.tobeto.entity.StockAlert;
import com.tobeto.service.StockAlertService;

@RestController
@RequestMapping("/api/v1/stockalert")
public class StockAlertController {
	@Autowired
	private StockAlertService stockAlertService;
	@Autowired
	@Qualifier("requestMapper")
	private ModelMapper requestMapper;
	@Autowired
	@Qualifier("responseMapper")
	private ModelMapper responseMapper;

	@PostMapping("/add")
	public AddStockAlertResponseDTO addStockAlert(@RequestBody AddStockAlertRequestDTO dto) {
		StockAlert stockAlert = requestMapper.map(dto, StockAlert.class);
		stockAlertService.createStockAlert(stockAlert);
		return new AddStockAlertResponseDTO(stockAlert.getId());
	}

	@GetMapping("/get/all")
	public ResponseEntity<String> getStockAlert() {
		System.out.println("StockAlert getAll calisiyor!");
		ObjectMapper objectMapper = new ObjectMapper();
		String jsonResponse = "";

		try {
			jsonResponse = objectMapper.writeValueAsString(stockAlertService.getAllStockAlerts());
		} catch (JsonProcessingException e) {
			e.printStackTrace();
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}

		return new ResponseEntity<>(jsonResponse, HttpStatus.OK);
	}

	@PostMapping("/del")
	public SuccessResponseDTO deleteStockAlert(@RequestBody DeleteStockAlertRequestDTO dto) {
		stockAlertService.deleteStockAlert(dto.getId());
		return new SuccessResponseDTO();
	}

}