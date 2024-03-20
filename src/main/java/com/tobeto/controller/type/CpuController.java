package com.tobeto.controller.type;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tobeto.dto.SuccessResponseDTO;
import com.tobeto.dto.type.cpu.CpuAddRequestDTO;
import com.tobeto.dto.type.cpu.CpuDelRequestDTO;
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
	public SuccessResponseDTO addSubType(@RequestBody CpuAddRequestDTO dto) {
		Cpu cpu = requestMapper.map(dto, Cpu.class);
		cpuService.createCpu(cpu);
		return new SuccessResponseDTO();
	}

	@DeleteMapping(value = "/del", consumes = MediaType.APPLICATION_JSON_VALUE)
	public SuccessResponseDTO delSubType(@RequestBody CpuDelRequestDTO dto) {
		cpuService.deleteCpu(dto.getId());
		return new SuccessResponseDTO();
	}

	@PutMapping("/put")
	public SuccessResponseDTO putSubType(@RequestBody CpuPutRequestDTO dto) {
		Cpu cpu = requestMapper.map(dto, Cpu.class);
		cpuService.updateCpu(cpu.getId(), cpu);
		return new SuccessResponseDTO();
	}
}