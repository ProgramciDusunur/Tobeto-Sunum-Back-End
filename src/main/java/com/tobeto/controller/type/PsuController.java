package com.tobeto.controller.type;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tobeto.dto.SuccessResponseDTO;
import com.tobeto.dto.type.PsuRequestDTO;

@RestController
@RequestMapping("/api/v1/type/psu")
public class PsuController {

	@PostMapping(value = "/add", consumes = MediaType.APPLICATION_JSON_VALUE)
	public SuccessResponseDTO addSubType(@RequestBody PsuRequestDTO dto) {
		System.out.println("Psu Post calisiyor.");
		System.out.println(dto.getBrand());
		System.out.println(dto.getModel());
		System.out.println(dto.getEfficiency());
		System.out.println(dto.getType());
		System.out.println(dto.getWatt());

		// System.out.println(dto.getModel());
		return new SuccessResponseDTO();

	}
}
