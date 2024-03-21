package com.tobeto.entity;

import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class StockAlert {

		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		private int id;
		@Column(name = "employee_id")
		private UUID employeeId;
		@Column(name = "stock_id")
		private int stockId;
		@Column(name = "alert_quantity")
		private int alertQuantity;

	}

