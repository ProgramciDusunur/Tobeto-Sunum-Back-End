package com.tobeto.entity.type;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class CpuCooler {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String type;
	@Column(name = "fan_length")
	private String fanLength;
	private int rpm;
	private String material;
	private String led;
	private String brand;
	private String model;

}