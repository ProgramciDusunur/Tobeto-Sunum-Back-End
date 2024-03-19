package com.tobeto.controller.type;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tobeto.dto.SuccessResponseDTO;
import com.tobeto.dto.type.CpuRequestDTO;
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
	public SuccessResponseDTO addSubType(@RequestBody CpuRequestDTO dto) {
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
}