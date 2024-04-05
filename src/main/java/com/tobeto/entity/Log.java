package com.tobeto.entity;

import java.time.LocalDateTime;
import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class Log {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(name = "shelf_id")
	private int shelfId;
	@Column(name = "stock_id")
	private int stockId;
	private int quantity;
	private LocalDateTime date;
	private String processType;
	private UUID employeeId;
}