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
import com.tobeto.dto.type.desktopcase.DesktopCaseAddRequestDTO;
import com.tobeto.dto.type.desktopcase.DesktopCaseDelRequestDTO;
import com.tobeto.dto.type.desktopcase.DesktopCasePutRequestDTO;
import com.tobeto.entity.type.DesktopCase;
import com.tobeto.service.type.DesktopCaseService;

import jakarta.annotation.security.RolesAllowed;

@RestController
@RequestMapping("/api/v1/type/case")
public class DesktopCaseController {
	@Autowired
	private DesktopCaseService caseService;

	@Autowired
	@Qualifier("requestMapper")
	private ModelMapper requestMapper;

	@Autowired
	@Qualifier("responseMapper")
	private ModelMapper responseMapper;

	@RolesAllowed("{admin}")
	@PostMapping("/add")
	public SuccessResponseDTO addDesktopCase(@RequestBody DesktopCaseAddRequestDTO dto) {
		DesktopCase desktopCase = requestMapper.map(dto, DesktopCase.class);
		caseService.createDesktopCase(desktopCase);
		return new SuccessResponseDTO();
	}

	@DeleteMapping(value = "/del", consumes = MediaType.APPLICATION_JSON_VALUE)
	public SuccessResponseDTO delSubType(@RequestBody DesktopCaseDelRequestDTO dto) {
		System.out.println("Case Del calisiyor.");
		caseService.deleteCase(dto.getId());
		return new SuccessResponseDTO();
	}

	@PutMapping("/put")
	public SuccessResponseDTO putSubType(@RequestBody DesktopCasePutRequestDTO dto) {
		DesktopCase desktopCase = requestMapper.map(dto, DesktopCase.class);
		caseService.updateDesktopCase(desktopCase.getId(), desktopCase);
		return new SuccessResponseDTO();
	}

}