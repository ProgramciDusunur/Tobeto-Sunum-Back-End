package com.tobeto.controller.type;

import com.tobeto.dto.type.cpu.CpuPutRequestDTO;
import com.tobeto.dto.type.cpucooler.CpuCoolerPutRequestDTO;
import com.tobeto.entity.type.Cpu;
import com.tobeto.entity.type.CpuCooler;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import com.tobeto.dto.SuccessResponseDTO;
import com.tobeto.dto.type.cpucooler.CpuCoolerAddRequestDTO;
import com.tobeto.dto.type.cpucooler.CpuCoolerDelRequestDTO;
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
	public SuccessResponseDTO addSubType(@RequestBody CpuCoolerAddRequestDTO dto) {
		System.out.println("CpuCooler Post calisiyor.");
		System.out.println(dto.getBrand());
		System.out.println(dto.getFanLength());
		System.out.println(dto.getLed());
		System.out.println(dto.getMaterial());
		System.out.println(dto.getModel());
		System.out.println(dto.getRpm());
		System.out.println(dto.getType());

		CpuCooler cpuCooler = requestMapper.map(dto, CpuCooler.class);
		cpuCoolerService.createCpuCooler(cpuCooler);
		return new SuccessResponseDTO();
	}

	@DeleteMapping(value = "/del", consumes = MediaType.APPLICATION_JSON_VALUE)
	public SuccessResponseDTO delSubType(@RequestBody CpuCoolerDelRequestDTO dto) {
		System.out.println("CpuCooler Del calisiyor.");

		cpuCoolerService.deleteCpuCooler(dto.getId());

		// System.out.println(dto.getModel());
		return new SuccessResponseDTO();
	}
	@PutMapping("/put")
	public SuccessResponseDTO putSubType(@RequestBody CpuCoolerPutRequestDTO dto) {
		CpuCooler cpuCooler = requestMapper.map(dto, CpuCooler.class);
		/*
		 * cpu.setBrand(dto.getBrand()); cpu.setClockSpeed(dto.getClockSpeed());
		 * cpu.setGeneration(dto.getGeneration()); cpu.setCoreCount(dto.getCoreCount());
		 * cpu.setModel(dto.getModel()); cpu.setSeries(dto.getSeries());
		 * cpu.setSocketType(dto.getSocketType());
		 */
		cpuCoolerService.updateCpuCooler(cpuCooler.getId(), cpuCooler);
		return new SuccessResponseDTO();
	}
}
