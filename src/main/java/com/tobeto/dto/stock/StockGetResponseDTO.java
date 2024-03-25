package com.tobeto.dto.stock;

import lombok.Data;

@Data
public class StockGetResponseDTO {
	private int id;
	private String type;
	private int quantity;
	private int typeId;
}
