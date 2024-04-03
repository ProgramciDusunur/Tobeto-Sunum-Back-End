package com.tobeto.dto.alert;

import java.util.List;

import com.tobeto.entity.StockAlert;

import lombok.Data;

@Data
public class GetAllStockAlertResponse {
	private List<StockAlert> allStockAlerts;
}
