package com.tobeto.controller.type;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tobeto.dto.SuccessResponseDTO;
import com.tobeto.dto.type.CpuCoolerRequestDTO;

@RestController
@RequestMapping("/api/v1/type/cpucooler")
public class CpuCoolerController {

	@PostMapping("/add")
	public SuccessResponseDTO addSubType(@RequestBody CpuCoolerRequestDTO dto) {
		System.out.println("CpuCooler Post calisiyor.");
		System.out.println(dto.getBrand());
		System.out.println(dto.getFanLength());
		System.out.println(dto.getLed());
		System.out.println(dto.getMaterial());
		System.out.println(dto.getModel());
		System.out.println(dto.getRpm());
		System.out.println(dto.getType());
		return new SuccessResponseDTO();
	}
}
