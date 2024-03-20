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
import com.tobeto.dto.type.psu.PsuAddRequestDTO;
import com.tobeto.dto.type.psu.PsuDelRequestDTO;
import com.tobeto.dto.type.psu.PsuPutRequestDTO;
import com.tobeto.entity.type.Psu;
import com.tobeto.service.type.PsuService;

@RestController
@RequestMapping("/api/v1/type/psu")
public class PsuController {
	@Autowired
	private PsuService psuService;

	@Autowired
	@Qualifier("requestMapper")
	private ModelMapper requestMapper;

	@Autowired
	@Qualifier("responseMapper")
	private ModelMapper responseMapper;

	@PostMapping(value = "/add", consumes = MediaType.APPLICATION_JSON_VALUE)
	public SuccessResponseDTO addSubType(@RequestBody PsuAddRequestDTO dto) {
		return new SuccessResponseDTO();
	}

	@DeleteMapping(value = "/del", consumes = MediaType.APPLICATION_JSON_VALUE)
	public SuccessResponseDTO delSubType(@RequestBody PsuDelRequestDTO dto) {
		psuService.deletePsu(dto.getId());
		return new SuccessResponseDTO();
	}

	@PutMapping("/put")
	public SuccessResponseDTO putSubType(@RequestBody PsuPutRequestDTO dto) {
		Psu psu = requestMapper.map(dto, Psu.class);
		psuService.updatePsu(psu.getId(), psu);
		return new SuccessResponseDTO();
	}
}
