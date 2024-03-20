package com.tobeto.controller.type;

import com.tobeto.dto.type.desktopcase.DesktopCaseDelRequestDTO;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tobeto.dto.SuccessResponseDTO;
import com.tobeto.dto.type.desktopcase.DesktopCaseAddRequestDTO;
import com.tobeto.entity.type.DesktopCase;
import com.tobeto.service.type.CaseService;

@RestController
@RequestMapping("/api/v1/type/case")
public class DesktopCaseController {
	@Autowired
	private CaseService caseService;

	@Autowired
	@Qualifier("requestMapper")
	private ModelMapper requestMapper;

	@Autowired
	@Qualifier("responseMapper")
	private ModelMapper responseMapper;

	@PostMapping("/add")
	public SuccessResponseDTO addCase(@RequestBody DesktopCaseAddRequestDTO dto) {
		DesktopCase desktopCase = requestMapper.map(dto, DesktopCase.class);
		caseService.createDesktopCase(desktopCase);
		return new SuccessResponseDTO();
	}

	@DeleteMapping(value = "/del", consumes = MediaType.APPLICATION_JSON_VALUE)
	public SuccessResponseDTO delSubType(@RequestBody DesktopCaseDelRequestDTO dto) {
		System.out.println("Case Del calisiyor.");

		caseService.deleteCase(dto.getId());

		// System.out.println(dto.getModel());
		return new SuccessResponseDTO();
	}
	
}