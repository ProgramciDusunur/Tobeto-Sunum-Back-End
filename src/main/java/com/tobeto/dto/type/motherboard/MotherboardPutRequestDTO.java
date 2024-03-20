package com.tobeto.dto.type.motherboard;

import lombok.Data;

@Data
public class MotherboardPutRequestDTO {
	private int id;
	private String cpuSocketType;
	private boolean cpuCompatibility;
	private String ramType;
	private String size;
	private int ramSlots;
	private String brand;
	private String model;
}
