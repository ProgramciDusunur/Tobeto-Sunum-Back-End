package com.tobeto.controller.type;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tobeto.dto.SuccessResponseDTO;
import com.tobeto.dto.type.GpuRequestDTO;
import com.tobeto.entity.type.Gpu;
import com.tobeto.service.type.GpuService;

@RestController
@RequestMapping(value = "/api/v1/type/gpu")
public class GpuController {
	@Autowired
	private GpuService gpuService;
	@Autowired
	@Qualifier("requestMapper")
	private ModelMapper requestMapper;
	@Autowired
	@Qualifier("responseMapper")
	private ModelMapper responseMapper;

	@PostMapping(value = "/add", consumes = MediaType.APPLICATION_JSON_VALUE)
	public SuccessResponseDTO addSubType(@RequestBody GpuRequestDTO dto) {
		System.out.println("Gpu Post calisiyor.");
		System.out.println(dto.getMemoryInterface());
		System.out.println(dto.getModel());
		System.out.println(dto.getProducer());
		System.out.println(dto.getBrand());
		System.out.println(dto.getVram());
		System.out.println(dto.getSeries());
		Gpu gpu = requestMapper.map(dto, Gpu.class);
		gpuService.createGpu(gpu);

		// System.out.println(dto.getModel());
		return new SuccessResponseDTO();

	}
}