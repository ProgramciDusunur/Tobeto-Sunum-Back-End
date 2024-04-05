package com.tobeto.controller;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.tobeto.dto.SuccessResponseDTO;
import com.tobeto.dto.stock.StockAddRequestDTO;
import com.tobeto.dto.stock.StockDelDecreaseQuantityRequestDTO;
import com.tobeto.dto.stock.StockDelRequestDTO;
import com.tobeto.dto.stock.StockGetRequestDTO;
import com.tobeto.dto.stock.StockGetResponseDTO;
import com.tobeto.entity.Stock;
import com.tobeto.service.StockService;

@RestController
@RequestMapping("/api/v1/stock")
public class StockController {
	@Autowired
	private StockService stockService;
	@Autowired
	@Qualifier("requestMapper")
	private ModelMapper requestMapper;
	@Autowired
	@Qualifier("responseMapper")
	private ModelMapper responseMapper;

	@PostMapping("/add")
	public SuccessResponseDTO addStock(@RequestBody StockAddRequestDTO dto) {
		Stock stock = requestMapper.map(dto, Stock.class);
		stockService.createStock(stock);
		return new SuccessResponseDTO();
	}

	@GetMapping("/get")
	public StockGetResponseDTO getStock(@RequestBody StockGetRequestDTO dto) {
		Stock stock = stockService.readStock(dto.getId());
		StockGetResponseDTO response = responseMapper.map(stock, StockGetResponseDTO.class);
		return response;
	}

	@DeleteMapping("/del/decrease/quantity")
	public SuccessResponseDTO decreaseStockQuantity(@RequestBody StockDelDecreaseQuantityRequestDTO dto) {
		stockService.decreaseStockQuantity(dto.getId(), dto.getQuantity());
		return new SuccessResponseDTO();
	}

	@DeleteMapping("/del")
	public SuccessResponseDTO deleteStock(@RequestBody StockDelRequestDTO dto) {
		stockService.deleteStock(dto.getId());
		return new SuccessResponseDTO();
	}

	@GetMapping("/get/all")
	public ResponseEntity<String> getAllStocks() {
		System.out.println("Get all calisiyor..");
		List<Stock> stocks = stockService.findAllStocks();
		System.out.println(stocks.size());
		for (Stock stocks1 : stocks) {
			System.out.println(stocks1);

		}
		// ObjectMapper kullanarak JSON'a dönüştürme (daha kolay kullanım için)
		ObjectMapper objectMapper = new ObjectMapper();
		String jsonResponse = "";
		try {
			jsonResponse = objectMapper.writeValueAsString(stocks);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity<>(jsonResponse, HttpStatus.OK);
	}

	/*
	 * @GetMapping("/get/all") public ResponseEntity<String> getAllShelves() {
	 * System.out.println("Raflarin tumunu alma basarili"); //
	 * ShelfGetAllResponseDTO response = new ShelfGetAllResponseDTO(); List<Shelf>
	 * allShelves = shelfService.getAllShelves(); //
	 * response.setAllAvailableShelves(allShelves);
	 * 
	 * // ObjectMapper kullanarak JSON'a dönüştürme (daha kolay kullanım için)
	 * ObjectMapper objectMapper = new ObjectMapper(); String jsonResponse = ""; try
	 * { jsonResponse = objectMapper.writeValueAsString(allShelves); } catch
	 * (JsonProcessingException e) { e.printStackTrace(); return new
	 * ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR); }
	 * 
	 * return new ResponseEntity<>(jsonResponse, HttpStatus.OK); }
	 */

}