package com.tobeto.controller.type;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.tobeto.dto.SuccessResponseDTO;
import com.tobeto.dto.type.motherboard.MotherboardAddRequestDTO;
import com.tobeto.dto.type.motherboard.MotherboardAddResponseDTO;
import com.tobeto.dto.type.motherboard.MotherboardDelRequestDTO;
import com.tobeto.dto.type.motherboard.MotherboardGetRequestDTO;
import com.tobeto.dto.type.motherboard.MotherboardPutRequestDTO;
import com.tobeto.entity.type.Motherboard;
import com.tobeto.service.type.MotherboardService;

@RestController
@RequestMapping("/api/v1/type/motherboard")
public class MotherboardController {
	@Autowired
	private MotherboardService motherboardService;

	@Autowired
	@Qualifier("requestMapper")
	private ModelMapper requestMapper;

	@Autowired
	@Qualifier("responseMapper")
	private ModelMapper responseMapper;

	@PostMapping(value = "/add", consumes = MediaType.APPLICATION_JSON_VALUE)
	public MotherboardAddResponseDTO addSubType(@RequestBody MotherboardAddRequestDTO dto) {
		Motherboard motherboard = requestMapper.map(dto, Motherboard.class);
		Motherboard createdMotherboard = motherboardService.createMotherboard(motherboard);
		return new MotherboardAddResponseDTO(createdMotherboard.getId());
	}

	@DeleteMapping(value = "/del", consumes = MediaType.APPLICATION_JSON_VALUE)
	public SuccessResponseDTO delSubType(@RequestBody MotherboardDelRequestDTO dto) {
		motherboardService.deleteMotherboard(dto.getId());
		return new SuccessResponseDTO();
	}

	@PostMapping(value = "/get", consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> getSubType(@RequestBody MotherboardGetRequestDTO dto) {
		Motherboard motherboard = motherboardService.readMotherboard(dto.getTypeId());

		// ObjectMapper kullanarak JSON'a dönüştürme (daha kolay kullanım için)
		ObjectMapper objectMapper = new ObjectMapper();
		String jsonResponse = "";
		try {
			jsonResponse = objectMapper.writeValueAsString(motherboard);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}

		return new ResponseEntity<>(jsonResponse, HttpStatus.OK);
	}

	@PutMapping("/put")
	public SuccessResponseDTO putSubType(@RequestBody MotherboardPutRequestDTO dto) {
		Motherboard motherboard = requestMapper.map(dto, Motherboard.class);
		motherboardService.updateMotherboard(motherboard.getId(), motherboard);
		return new SuccessResponseDTO();
	}
}
