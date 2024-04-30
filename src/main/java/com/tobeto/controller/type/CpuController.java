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
import com.tobeto.dto.type.cpu.CpuAddRequestDTO;
import com.tobeto.dto.type.cpu.CpuAddResponseDTO;
import com.tobeto.dto.type.cpu.CpuDelRequestDTO;
import com.tobeto.dto.type.cpu.CpuGetRequestDTO;
import com.tobeto.dto.type.cpu.CpuPutRequestDTO;
import com.tobeto.entity.type.Cpu;
import com.tobeto.service.type.CpuService;

@RestController
@RequestMapping("/api/v1/type/cpu")
public class CpuController {
	@Autowired
	private CpuService cpuService;
	@Autowired
	@Qualifier("requestMapper")
	private ModelMapper requestMapper;
	@Autowired
	@Qualifier("responseMapper")
	private ModelMapper responseMapper;

	@PostMapping("/add")
	public CpuAddResponseDTO addSubType(@RequestBody CpuAddRequestDTO dto) {
		Cpu cpu = requestMapper.map(dto, Cpu.class);
		Cpu createdCpu = cpuService.createCpu(cpu);
		return new CpuAddResponseDTO(createdCpu.getId());
	}

	@DeleteMapping(value = "/del", consumes = MediaType.APPLICATION_JSON_VALUE)
	public SuccessResponseDTO delSubType(@RequestBody CpuDelRequestDTO dto) {
		cpuService.deleteCpu(dto.getId());
		return new SuccessResponseDTO();
	}

	@PostMapping(value = "/get", consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> getSubType(@RequestBody CpuGetRequestDTO dto) {
		Cpu cpu = cpuService.readCpu(dto.getTypeId());

		// ObjectMapper kullanarak JSON'a dönüştürme (daha kolay kullanım için)
		ObjectMapper objectMapper = new ObjectMapper();
		String jsonResponse = "";
		try {
			jsonResponse = objectMapper.writeValueAsString(cpu);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}

		return new ResponseEntity<>(jsonResponse, HttpStatus.OK);
	}

	@PutMapping("/put")
	public SuccessResponseDTO putSubType(@RequestBody CpuPutRequestDTO dto) {
		Cpu cpu = requestMapper.map(dto, Cpu.class);
		cpuService.updateCpu(cpu.getId(), cpu);
		return new SuccessResponseDTO();
	}
}