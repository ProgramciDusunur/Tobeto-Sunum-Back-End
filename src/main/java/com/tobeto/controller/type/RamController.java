package com.tobeto.controller.type;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tobeto.dto.SuccessResponseDTO;
import com.tobeto.dto.type.ram.RamAddRequestDTO;
import com.tobeto.dto.type.ram.RamDelRequestDTO;
import com.tobeto.service.type.RamService;

@RestController
@RequestMapping("/api/v1/type/ram")
public class RamController {
	@Autowired
	private RamService ramService;
	@PostMapping(value = "/add", consumes = MediaType.APPLICATION_JSON_VALUE)
	public SuccessResponseDTO addSubType(@RequestBody RamAddRequestDTO dto) {
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
	@DeleteMapping(value = "/del", consumes = MediaType.APPLICATION_JSON_VALUE)
	public SuccessResponseDTO delSubType(@RequestBody RamDelRequestDTO dto) {
		System.out.println("Ram Del calisiyor.");
		
		
		ramService.deleteRam(dto.getId());
		

		// System.out.println(dto.getModel());
		return new SuccessResponseDTO();
	}
}
