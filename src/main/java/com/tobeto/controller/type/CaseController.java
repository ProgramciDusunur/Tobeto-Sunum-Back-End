package com.tobeto.controller.type;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tobeto.dto.SuccessResponseDTO;
import com.tobeto.dto.type.CaseRequestDTO;
import com.tobeto.entity.type.Case;
import com.tobeto.service.type.CaseService;

@RestController
@RequestMapping("/api/v1/type/case")
public class CaseController {
	@Autowired
	private CaseService caseService;

	@Autowired
	@Qualifier("requestMapper")
	private ModelMapper requestMapper;

	@Autowired
	@Qualifier("responseMapper")
	private ModelMapper responseMapper;

	@PostMapping("/create")
	public SuccessResponseDTO createCase(@RequestBody CaseRequestDTO dto) {
		Case casee = requestMapper.map(dto, Case.class);
		caseService.createCase(casee);
		return new SuccessResponseDTO();
	}
}