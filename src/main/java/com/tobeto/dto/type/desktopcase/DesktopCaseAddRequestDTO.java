package com.tobeto.dto.type.desktopcase;

import lombok.Data;

@Data
public class DesktopCaseAddRequestDTO {
	private String brand;
	private boolean psu;
	private String psuLocation;
	private boolean transparent;
	private int psuWatt;
	private String model;
	private String type;

}
