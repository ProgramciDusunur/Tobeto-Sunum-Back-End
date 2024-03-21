package com.tobeto.entity;

import java.util.Objects;

import jakarta.persistence.Column;
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
	@Column(name = "occupied_quantity")
	private int occupiedQuantity;
	@Column(name = "stock_id", unique = false)
	private int stockId;

	// equals ve hashCode metodlarını id üzerinden yeniden uygula
	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		Shelf shelf = (Shelf) o;
		return id == shelf.id;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

}
