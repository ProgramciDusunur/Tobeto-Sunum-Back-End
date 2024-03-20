package com.tobeto.dto.type.motherboard;

import lombok.Data;

@Data
public class MotherboardAddRequestDTO {
	private String cpuSocketType;
	// Intel = true, AMD = false
	private boolean cpuCompatibility;
	private String ramType;
	private String size;
	private int ramSlots;
	private String brand;
	private String model;
}
