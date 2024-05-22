package com.tobeto.entity;

import java.util.Date;
import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class StockLog {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(name = "transaction_code", nullable = false, columnDefinition = "BINARY(16)")
	private UUID transactionCode;

	@Column(name = "transaction_date", nullable = false)
	private Date transactionDate;

	@Column(name = "user", nullable = false, length = 20)
	private String user;

	@Column(name = "user_id", nullable = false, columnDefinition = "BINARY(16)")
	private UUID userId;

	@Column(name = "product_type", nullable = false, length = 45)
	private String productType;

	@Column(name = "product_id", nullable = false)
	private Integer productId;

	@Column(name = "quantity", nullable = false)
	private Integer quantity;

	@Column(name = "transaction_type", nullable = false, length = 45)
	private String transactionType;

	@Column(name = "transaction_detail", length = 100)
	private String transactionDetail;

	@Column(name = "transaction_status", nullable = false, length = 45)
	private String transactionStatus;

	@Column(name = "error_message", length = 45)
	private String errorMessage;

}
