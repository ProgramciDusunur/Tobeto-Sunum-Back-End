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
import com.tobeto.dto.type.ram.RamAddRequestDTO;
import com.tobeto.dto.type.ram.RamDelRequestDTO;
import com.tobeto.dto.type.ram.RamPutRequestDTO;
import com.tobeto.entity.type.Ram;
import com.tobeto.service.type.RamService;

@RestController
@RequestMapping("/api/v1/type/ram")
public class RamController {
	@Autowired
	private RamService ramService;

	@Autowired
	@Qualifier("requestMapper")
	private ModelMapper requestMapper;

	@Autowired
	@Qualifier("responseMapper")
	private ModelMapper responseMapper;

	@PostMapping(value = "/add", consumes = MediaType.APPLICATION_JSON_VALUE)
	public SuccessResponseDTO addSubType(@RequestBody RamAddRequestDTO dto) {
		Ram ram = requestMapper.map(dto, Ram.class);
		ramService.createRam(ram);
		return new SuccessResponseDTO();
	}

	@DeleteMapping(value = "/del", consumes = MediaType.APPLICATION_JSON_VALUE)
	public SuccessResponseDTO delSubType(@RequestBody RamDelRequestDTO dto) {
		ramService.deleteRam(dto.getId());
		return new SuccessResponseDTO();
	}

	@PutMapping("/put")
	public SuccessResponseDTO putSubType(@RequestBody RamPutRequestDTO dto) {
		Ram ram = requestMapper.map(dto, Ram.class);
		ramService.updateRam(ram.getId(), ram);
		return new SuccessResponseDTO();
	}
}
