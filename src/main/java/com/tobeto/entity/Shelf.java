package com.tobeto.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Shelf {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(name = "occupied_quantity")
	private int occupiedQuantity;
	@Column(name = "stock_id")
	private int stockId;

}
