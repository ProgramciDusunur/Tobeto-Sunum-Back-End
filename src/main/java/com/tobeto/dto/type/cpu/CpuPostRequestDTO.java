package com.tobeto.dto.type.cpu;

import lombok.Data;

@Data
public class CpuPostRequestDTO {
	private int id;
	private String brand;
	private int clockSpeed;
	private String socketType;
	private String generation;
	private String series;
	private int coreCount;
	private String model;
}
