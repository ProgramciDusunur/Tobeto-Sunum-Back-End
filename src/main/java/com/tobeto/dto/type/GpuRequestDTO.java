package com.tobeto.dto.type;

import lombok.Data;

@Data
public class GpuRequestDTO {

	private String brand;
	private String producer;
	private String series;
	private String model;
	private int vram;
	private int memoryInterface;

}
