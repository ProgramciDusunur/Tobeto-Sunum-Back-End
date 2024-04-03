package com.tobeto.dto.alert;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AddStockAlertRequestDTO {
	private int stockId;
	private int alertQuantity;

}
