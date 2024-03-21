package com.tobeto.controller;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tobeto.dto.SuccessResponseDTO;
import com.tobeto.dto.stock.StockAddRequestDTO;
import com.tobeto.dto.stock.StockGetRequestDTO;
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
	public SuccessResponseDTO getStock(@RequestBody StockGetRequestDTO dto) {

		return new SuccessResponseDTO();
	}

}
