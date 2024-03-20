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
import com.tobeto.dto.type.motherboard.MotherboardAddRequestDTO;
import com.tobeto.dto.type.motherboard.MotherboardDelRequestDTO;
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
	public SuccessResponseDTO addSubType(@RequestBody MotherboardAddRequestDTO dto) {
		System.out.println("Motherboard Post calisiyor.");
		System.out.println(dto.getBrand());
		System.out.println(dto.getModel());
		System.out.println(dto.getSize());
		System.out.println(dto.getRamType());
		System.out.println(dto.getCpuSocketType());
		System.out.println(dto.getRamSlots());
		System.out.println(dto.isCpuCompatibility());

		// System.out.println(dto.getModel());
		return new SuccessResponseDTO();

	}

	@DeleteMapping(value = "/del", consumes = MediaType.APPLICATION_JSON_VALUE)
	public SuccessResponseDTO delSubType(@RequestBody MotherboardDelRequestDTO dto) {
		System.out.println("Motherboard Del calisiyor.");

		motherboardService.deleteMotherboard(dto.getId());

		// System.out.println(dto.getModel());
		return new SuccessResponseDTO();
	}

	@PutMapping("/put")
	public SuccessResponseDTO putSubType(@RequestBody MotherboardPutRequestDTO dto) {
		Motherboard motherboard = requestMapper.map(dto, Motherboard.class);
		/*
		 * cpu.setBrand(dto.getBrand()); cpu.setClockSpeed(dto.getClockSpeed());
		 * cpu.setGeneration(dto.getGeneration()); cpu.setCoreCount(dto.getCoreCount());
		 * cpu.setModel(dto.getModel()); cpu.setSeries(dto.getSeries());
		 * cpu.setSocketType(dto.getSocketType());
		 */
		motherboardService.updateMotherboard(motherboard.getId(), motherboard);
		return new SuccessResponseDTO();
	}
}
