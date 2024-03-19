package com.tobeto.controller.type;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tobeto.dto.SuccessResponseDTO;
import com.tobeto.dto.type.MotherboardRequestDTO;

@RestController
@RequestMapping("/api/v1/type/motherboard")
public class MotherboardController {

	@PostMapping(value = "/add", consumes = MediaType.APPLICATION_JSON_VALUE)
	public SuccessResponseDTO addSubType(@RequestBody MotherboardRequestDTO dto) {
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
}
