package com.tobeto.entity.type;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Gpu {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String brand;
	private String producer;
	private String series;
	private String model;
	private int vram;
	@Column(name = "memory_interface")
	private int memoryInterface;

}
