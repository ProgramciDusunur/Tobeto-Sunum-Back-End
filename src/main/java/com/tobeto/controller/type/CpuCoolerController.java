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
import com.tobeto.dto.type.cpucooler.CpuCoolerAddRequestDTO;
import com.tobeto.dto.type.cpucooler.CpuCoolerDelRequestDTO;
import com.tobeto.dto.type.cpucooler.CpuCoolerPutRequestDTO;
import com.tobeto.entity.type.CpuCooler;
import com.tobeto.service.type.CpuCoolerService;

@RestController
@RequestMapping("/api/v1/type/cpucooler")
public class CpuCoolerController {
	@Autowired
	private CpuCoolerService cpuCoolerService;
	@Autowired
	@Qualifier("requestMapper")
	private ModelMapper requestMapper;
	@Autowired
	@Qualifier("responseMapper")
	private ModelMapper responseMapper;

	@PostMapping("/add")
	public SuccessResponseDTO addSubType(@RequestBody CpuCoolerAddRequestDTO dto) {

		CpuCooler cpuCooler = requestMapper.map(dto, CpuCooler.class);
		cpuCoolerService.createCpuCooler(cpuCooler);
		return new SuccessResponseDTO();
	}

	@DeleteMapping(value = "/del", consumes = MediaType.APPLICATION_JSON_VALUE)
	public SuccessResponseDTO delSubType(@RequestBody CpuCoolerDelRequestDTO dto) {
		System.out.println("CpuCooler Del calisiyor.");
		cpuCoolerService.deleteCpuCooler(dto.getId());
		return new SuccessResponseDTO();
	}

	@PutMapping("/put")
	public SuccessResponseDTO putSubType(@RequestBody CpuCoolerPutRequestDTO dto) {
		CpuCooler cpuCooler = requestMapper.map(dto, CpuCooler.class);
		cpuCoolerService.updateCpuCooler(cpuCooler.getId(), cpuCooler);
		return new SuccessResponseDTO();
	}
}
