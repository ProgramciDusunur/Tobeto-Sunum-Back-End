package com.tobeto.entity.type;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Motherboard {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(name = "cpu_socket_type")
	private String cpuSocketType;
	@Column(name = "cpu_compatibility")
	private boolean cpuCompatibility;
	@Column(name = "ram_type")
	private String ramType;
	private String size;
	@Column(name = "ram_slots")
	private int ramSlots;
	private String brand;
	private String model;

}
