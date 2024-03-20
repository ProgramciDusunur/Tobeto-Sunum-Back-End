package com.tobeto.dto.type.gpu;

import lombok.Data;

@Data
public class GpuAddRequestDTO {

	private String brand;
	private String producer;
	private String series;
	private String model;
	private int vram;
	private int memoryInterface;

}
