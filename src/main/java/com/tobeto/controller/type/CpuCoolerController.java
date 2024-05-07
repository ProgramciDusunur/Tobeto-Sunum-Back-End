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
import com.tobeto.dto.type.cpucooler.CpuCoolerAddRequestDTO;
import com.tobeto.dto.type.cpucooler.CpuCoolerAddResponseDTO;
import com.tobeto.dto.type.cpucooler.CpuCoolerDelRequestDTO;
import com.tobeto.dto.type.cpucooler.CpuCoolerGetRequestDTO;
import com.tobeto.dto.type.cpucooler.CpuCoolerPutRequestDTO;
import com.tobeto.entity.type.CpuCooler;
import com.tobeto.service.type.CpuCoolerService;

@RestController
@RequestMapping("/api/v1/type/cpucooler")
public class CpuCoolerController {
	@Autowired
	private CpuCoolerService cpuCoolerService;
	@Autowired
	@Qualifier("requestMapper")
	private ModelMapper requestMapper;
	@Autowired
	@Qualifier("responseMapper")
	private ModelMapper responseMapper;

	@PostMapping("/add")
	public CpuCoolerAddResponseDTO addSubType(@RequestBody CpuCoolerAddRequestDTO dto) {
		CpuCooler cpuCooler = requestMapper.map(dto, CpuCooler.class);
		CpuCooler createdCpuCooler = cpuCoolerService.createCpuCooler(cpuCooler);
		return new CpuCoolerAddResponseDTO(createdCpuCooler.getId());
	}

	@DeleteMapping(value = "/del", consumes = MediaType.APPLICATION_JSON_VALUE)
	public SuccessResponseDTO delSubType(@RequestBody CpuCoolerDelRequestDTO dto) {
		cpuCoolerService.deleteCpuCooler(dto.getId());
		return new SuccessResponseDTO();
	}

	@PostMapping(value = "/get", consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> getSubType(@RequestBody CpuCoolerGetRequestDTO dto) {
		CpuCooler cpuCooler = cpuCoolerService.readCpuCooler(dto.getTypeId());

		// ObjectMapper kullanarak JSON'a dönüştürme (daha kolay kullanım için)
		ObjectMapper objectMapper = new ObjectMapper();
		String jsonResponse = "";
		try {
			jsonResponse = objectMapper.writeValueAsString(cpuCooler);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}

		return new ResponseEntity<>(jsonResponse, HttpStatus.OK);
	}

	@GetMapping(value = "/get/all")
	public ResponseEntity<String> getAllSubType() {
		List<CpuCooler> allCpuCoolers = cpuCoolerService.readAllCpuCoolers();

		ObjectMapper objectMapper = new ObjectMapper();
		String jsonResponse = "";
		try {
			jsonResponse = objectMapper.writeValueAsString(allCpuCoolers);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}

		return new ResponseEntity<>(jsonResponse, HttpStatus.OK);
	}

	@PostMapping("/put")
	public SuccessResponseDTO putSubType(@RequestBody CpuCoolerPutRequestDTO dto) {
		CpuCooler cpuCooler = requestMapper.map(dto, CpuCooler.class);
		cpuCoolerService.updateCpuCooler(cpuCooler.getId(), cpuCooler);
		return new SuccessResponseDTO();
	}
}
