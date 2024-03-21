package com.tobeto.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tobeto.entity.Shelf;
import com.tobeto.repository.ShelfRepository;

@Service
public class ShelfService {
	@Autowired
	private ShelfRepository shelfRepository;

	public void createShelf(Shelf shelf) {
		shelfRepository.insertShelf(shelf.getOccupiedQuantity(), shelf.getStockId());
	}

	public List<Shelf> findAllByStockId(int stockId) {
		List<Shelf> shelfList = shelfRepository.findAllByStockId(stockId);
		return shelfList;
	}

}
