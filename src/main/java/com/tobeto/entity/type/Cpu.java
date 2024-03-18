package com.tobeto.entity.type;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Cpu {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String brand;

	@Column(name = "clock_speed")
	private int clockSpeed;
	@Column(name = "socket_type")
	private String socketType;
	private String generation;
	private String series;
	@Column(name = "core_count")
	private int coreCount;
	private String model;
}