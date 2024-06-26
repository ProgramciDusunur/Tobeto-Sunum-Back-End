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
import com.tobeto.dto.type.ram.RamAddRequestDTO;
import com.tobeto.dto.type.ram.RamAddResponseDTO;
import com.tobeto.dto.type.ram.RamDelRequestDTO;
import com.tobeto.dto.type.ram.RamGetRequestDTO;
import com.tobeto.dto.type.ram.RamPutRequestDTO;
import com.tobeto.entity.type.Ram;
import com.tobeto.service.type.RamService;

@RestController
@RequestMapping("/api/v1/type/ram")
public class RamController {
	@Autowired
	private RamService ramService;

	@Autowired
	@Qualifier("requestMapper")
	private ModelMapper requestMapper;

	@Autowired
	@Qualifier("responseMapper")
	private ModelMapper responseMapper;

	@PostMapping(value = "/add", consumes = MediaType.APPLICATION_JSON_VALUE)
	public RamAddResponseDTO addSubType(@RequestBody RamAddRequestDTO dto) {
		Ram ram = requestMapper.map(dto, Ram.class);
		Ram createdRam = ramService.createRam(ram);
		return new RamAddResponseDTO(createdRam.getId());
	}

	@DeleteMapping(value = "/del", consumes = MediaType.APPLICATION_JSON_VALUE)
	public SuccessResponseDTO delSubType(@RequestBody RamDelRequestDTO dto) {
		ramService.deleteRam(dto.getId());
		return new SuccessResponseDTO();
	}

	@PostMapping(value = "/get", consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> getSubType(@RequestBody RamGetRequestDTO dto) {
		Ram ram = ramService.readRam(dto.getTypeId());

		// ObjectMapper kullanarak JSON'a dönüştürme (daha kolay kullanım için)
		ObjectMapper objectMapper = new ObjectMapper();
		String jsonResponse = "";
		try {
			jsonResponse = objectMapper.writeValueAsString(ram);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}

		return new ResponseEntity<>(jsonResponse, HttpStatus.OK);
	}

	@GetMapping(value = "/get/all")
	public ResponseEntity<String> getAllSubType() {
		List<Ram> allRam = ramService.readAllRam();

		ObjectMapper objectMapper = new ObjectMapper();
		String jsonResponse = "";
		try {
			jsonResponse = objectMapper.writeValueAsString(allRam);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}

		return new ResponseEntity<>(jsonResponse, HttpStatus.OK);
	}

	@PostMapping("/put")
	public SuccessResponseDTO putSubType(@RequestBody RamPutRequestDTO dto) {
		Ram ram = requestMapper.map(dto, Ram.class);
		ramService.updateRam(ram.getId(), ram);
		return new SuccessResponseDTO();
	}
}
