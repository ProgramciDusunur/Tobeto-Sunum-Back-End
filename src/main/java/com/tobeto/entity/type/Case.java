package com.tobeto.entity.type;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Case {
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
