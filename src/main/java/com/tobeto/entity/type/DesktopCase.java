package com.tobeto.entity.type;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class DesktopCase {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	private String brand;
	private boolean psu;
	@Column(name = "psu_location")
	private String psuLocation;
	private boolean transparent;
	@Column(name = "psu_watt")
	private int psuWatt;
	private String model;
	private String type;

}
