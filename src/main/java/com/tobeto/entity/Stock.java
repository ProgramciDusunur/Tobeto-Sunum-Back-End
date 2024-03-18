package com.tobeto.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Stock {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	private String type;
	private int quantity;
	@Column(name = "type_id")
	private int typeId;

}
