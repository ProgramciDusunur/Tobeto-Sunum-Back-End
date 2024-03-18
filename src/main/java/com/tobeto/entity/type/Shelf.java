package com.tobeto.entity.type;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class Shelf {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	private int occupied_quantity;
	private int stock_id;

}
