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
public class UserLog {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(name = "transaction_code", columnDefinition = "BINARY(16)")
	private UUID transactionCode;

	@Column(name = "user", nullable = false, length = 45)
	private String user;

	@Column(name = "user_id", nullable = false, columnDefinition = "BINARY(16)")
	private UUID userId;

	@Column(name = "transaction_date", nullable = false)
	private Date transactionDate;

	@Column(name = "transaction_type", nullable = false, length = 45)
	private String transactionType;

	@Column(name = "transaction_detail", nullable = false, length = 45)
	private String transactionDetail;

	@Column(name = "error_message", length = 45)
	private String errorMessage;

}
