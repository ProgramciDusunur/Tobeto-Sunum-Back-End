package com.tobeto.controller.type;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tobeto.dto.type.GpuRequestDTO;
import com.tobeto.dto.type.GpuResponseDTO;

@RestController
@RequestMapping(value = "/api/v1/type/gpu")
public class GpuController {

	@PostMapping(value = "/add", consumes = MediaType.APPLICATION_JSON_VALUE)
	public GpuResponseDTO addSubType(@RequestBody GpuRequestDTO dto) {
		System.out.println("Gpu Post calisiyor.");
		System.out.println(dto.getMemoryInterface());
		System.out.println(dto.getModel());
		System.out.println(dto.getProducer());
		System.out.println(dto.getBrand());
		System.out.println(dto.getVram());
		System.out.println(dto.getSeries());

		// System.out.println(dto.getModel());
		return new GpuResponseDTO();

	}
}