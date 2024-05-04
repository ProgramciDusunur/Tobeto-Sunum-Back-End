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
import com.tobeto.dto.type.gpu.GpuAddRequestDTO;
import com.tobeto.dto.type.gpu.GpuAddResponseDTO;
import com.tobeto.dto.type.gpu.GpuDelRequestDTO;
import com.tobeto.dto.type.gpu.GpuGetRequestDTO;
import com.tobeto.dto.type.gpu.GpuPutRequestDTO;
import com.tobeto.entity.type.Gpu;
import com.tobeto.service.type.GpuService;

@RestController
@RequestMapping(value = "/api/v1/type/gpu")
public class GpuController {
	@Autowired
	private GpuService gpuService;
	@Autowired
	@Qualifier("requestMapper")
	private ModelMapper requestMapper;
	@Autowired
	@Qualifier("responseMapper")
	private ModelMapper responseMapper;

	@PostMapping(value = "/add", consumes = MediaType.APPLICATION_JSON_VALUE)
	public GpuAddResponseDTO addSubType(@RequestBody GpuAddRequestDTO dto) {
		Gpu gpu = requestMapper.map(dto, Gpu.class);
		Gpu createdGpu = gpuService.createGpu(gpu);
		return new GpuAddResponseDTO(createdGpu.getId());

	}

	@DeleteMapping(value = "/del", consumes = MediaType.APPLICATION_JSON_VALUE)
	public SuccessResponseDTO delSubType(@RequestBody GpuDelRequestDTO dto) {
		gpuService.deleteGpu(dto.getId());
		return new SuccessResponseDTO();
	}

	@PostMapping(value = "/get", consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> getSubType(@RequestBody GpuGetRequestDTO dto) {
		Gpu gpu = gpuService.readGpu(dto.getTypeId());

		// ObjectMapper kullanarak JSON'a dönüştürme (daha kolay kullanım için)
		ObjectMapper objectMapper = new ObjectMapper();
		String jsonResponse = "";
		try {
			jsonResponse = objectMapper.writeValueAsString(gpu);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}

		return new ResponseEntity<>(jsonResponse, HttpStatus.OK);
	}

	@PostMapping("/put")
	public SuccessResponseDTO putSubType(@RequestBody GpuPutRequestDTO dto) {
		Gpu gpu = requestMapper.map(dto, Gpu.class);
		gpuService.updateGpu(gpu.getId(), gpu);
		return new SuccessResponseDTO();
	}
}