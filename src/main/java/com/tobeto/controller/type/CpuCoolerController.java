package com.tobeto.controller.type;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tobeto.dto.SuccessResponseDTO;
import com.tobeto.dto.type.CpuCoolerAddRequestDTO;
import com.tobeto.dto.type.CpuCoolerDelRequestDTO;
import com.tobeto.dto.type.CpuDelRequestDTO;
import com.tobeto.service.type.CpuCoolerService;

@RestController
@RequestMapping("/api/v1/type/cpucooler")
public class CpuCoolerController {
	@Autowired
	private CpuCoolerService cpuCoolerService;
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
		return new SuccessResponseDTO();
	}
	@DeleteMapping(value = "/del", consumes = MediaType.APPLICATION_JSON_VALUE)
	public SuccessResponseDTO delSubType(@RequestBody CpuCoolerDelRequestDTO dto) {
		System.out.println("CpuCooler Del calisiyor.");
		
		
		cpuCoolerService.deleteCpuCooler(dto.getId());
		

		// System.out.println(dto.getModel());
		return new SuccessResponseDTO();
	}
}
