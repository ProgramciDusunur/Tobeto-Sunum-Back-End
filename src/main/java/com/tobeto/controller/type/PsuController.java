package com.tobeto.controller.type;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
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
import com.tobeto.dto.type.psu.PsuAddRequestDTO;
import com.tobeto.dto.type.psu.PsuAddResponseDTO;
import com.tobeto.dto.type.psu.PsuDelRequestDTO;
import com.tobeto.dto.type.psu.PsuGetRequestDTO;
import com.tobeto.dto.type.psu.PsuPutRequestDTO;
import com.tobeto.entity.type.Psu;
import com.tobeto.service.type.PsuService;

@RestController
@RequestMapping("/api/v1/type/psu")
public class PsuController {
	@Autowired
	private PsuService psuService;

	@Autowired
	@Qualifier("requestMapper")
	private ModelMapper requestMapper;

	@Autowired
	@Qualifier("responseMapper")
	private ModelMapper responseMapper;

	@PostMapping(value = "/add", consumes = MediaType.APPLICATION_JSON_VALUE)
	public PsuAddResponseDTO addSubType(@RequestBody PsuAddRequestDTO dto) {
		Psu psu = requestMapper.map(dto, Psu.class);
		Psu createdPsu = psuService.createPsu(psu);
		return new PsuAddResponseDTO(createdPsu.getId());
	}

	@DeleteMapping(value = "/del", consumes = MediaType.APPLICATION_JSON_VALUE)
	public SuccessResponseDTO delSubType(@RequestBody PsuDelRequestDTO dto) {
		psuService.deletePsu(dto.getId());
		return new SuccessResponseDTO();
	}

	@PostMapping(value = "/get", consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> getSubType(@RequestBody PsuGetRequestDTO dto) {
		Psu psu = psuService.readPsu(dto.getTypeId());

		// ObjectMapper kullanarak JSON'a dönüştürme (daha kolay kullanım için)
		ObjectMapper objectMapper = new ObjectMapper();
		String jsonResponse = "";
		try {
			jsonResponse = objectMapper.writeValueAsString(psu);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}

		return new ResponseEntity<>(jsonResponse, HttpStatus.OK);
	}

	@GetMapping(value = "/get/all")
	public ResponseEntity<String> getAllSubType() {
		List<Psu> allPsu = psuService.readAllPsu();

		ObjectMapper objectMapper = new ObjectMapper();
		String jsonResponse = "";
		try {
			jsonResponse = objectMapper.writeValueAsString(allPsu);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}

		return new ResponseEntity<>(jsonResponse, HttpStatus.OK);
	}

	@PostMapping("/put")
	public SuccessResponseDTO putSubType(@RequestBody PsuPutRequestDTO dto) {
		Psu psu = requestMapper.map(dto, Psu.class);
		psuService.updatePsu(psu.getId(), psu);
		return new SuccessResponseDTO();
	}
}
