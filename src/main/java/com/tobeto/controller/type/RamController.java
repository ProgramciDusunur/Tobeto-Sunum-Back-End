package com.tobeto.controller.type;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tobeto.dto.SuccessResponseDTO;
import com.tobeto.dto.type.RamRequestDTO;

@RestController
@RequestMapping("/api/v1/type/ram")
public class RamController {

	@PostMapping(value = "/add", consumes = MediaType.APPLICATION_JSON_VALUE)
	public SuccessResponseDTO addSubType(@RequestBody RamRequestDTO dto) {
		System.out.println("Psu Post calisiyor.");
		System.out.println(dto.getBrand());
		System.out.println(dto.getModel());
		System.out.println(dto.getCapacity());
		System.out.println(dto.getType());
		System.out.println(dto.getChannelType());
		System.out.println(dto.getFrequencySpeed());
		System.out.println(dto.getCompatibility());

		// System.out.println(dto.getModel());
		return new SuccessResponseDTO();

	}
}
