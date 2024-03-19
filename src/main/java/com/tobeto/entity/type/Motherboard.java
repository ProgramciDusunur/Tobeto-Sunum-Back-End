package com.tobeto.entity.type;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
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
	// Intel = true, AMD = false
	private boolean cpuCompatibility;
	@Column(name = "ram_type")
	private String ramType;
	private String size;
	@Column(name = "ram_slots")
	private int ramSlots;
	private String brand;
	private String model;

}
