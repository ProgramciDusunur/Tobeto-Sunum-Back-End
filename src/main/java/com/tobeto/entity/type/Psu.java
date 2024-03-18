package com.tobeto.entity.type;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Psu {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private int watt;
	private String efficiency;
	private boolean modular;
	private String type;
	@Column(name = "pcie_gen_5_support")
	private boolean pcieGen5Support;
	private String brand;
	private String model;

}
