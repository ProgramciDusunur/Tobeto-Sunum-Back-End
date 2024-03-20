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
import com.tobeto.dto.type.CpuAddRequestDTO;
import com.tobeto.dto.type.CpuDelRequestDTO;
import com.tobeto.dto.type.CpuPutRequestDTO;
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
		System.out.println("Cpu Post calisiyor.");
		System.out.println(dto.getBrand());
		System.out.println(dto.getClockSpeed());
		System.out.println(dto.getCoreCount());
		System.out.println(dto.getGeneration());
		System.out.println(dto.getModel());
		System.out.println(dto.getSeries());
		System.out.println(dto.getSocketType());
		Cpu cpu = requestMapper.map(dto, Cpu.class);
		cpuService.createCpu(cpu);
		return new SuccessResponseDTO();
	}

	@DeleteMapping(value = "/del", consumes = MediaType.APPLICATION_JSON_VALUE)
	public SuccessResponseDTO delSubType(@RequestBody CpuDelRequestDTO dto) {
		System.out.println("Cpu Del calisiyor.");

		cpuService.deleteCpu(dto.getId());

		// System.out.println(dto.getModel());
		return new SuccessResponseDTO();
	}

	@PutMapping("/put")
	public SuccessResponseDTO putSubType(@RequestBody CpuPutRequestDTO dto) {
		Cpu cpu = requestMapper.map(dto, Cpu.class);
		/*
		 * cpu.setBrand(dto.getBrand()); cpu.setClockSpeed(dto.getClockSpeed());
		 * cpu.setGeneration(dto.getGeneration()); cpu.setCoreCount(dto.getCoreCount());
		 * cpu.setModel(dto.getModel()); cpu.setSeries(dto.getSeries());
		 * cpu.setSocketType(dto.getSocketType());
		 */
		cpuService.updateCpu(cpu.getId(), cpu);
		return new SuccessResponseDTO();
	}
}