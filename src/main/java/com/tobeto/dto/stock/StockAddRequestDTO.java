package com.tobeto.dto.stock;

import lombok.Data;

@Data
public class StockAddRequestDTO {
	private String type;
	private int quantity;
	private int typeId;
}
