package com.tobeto.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tobeto.entity.Shelf;
import com.tobeto.entity.Stock;
import com.tobeto.repository.StockRepository;
import com.tobeto.rules.Depot;

import jakarta.transaction.Transactional;

@Service
public class StockService {
	@Autowired
	private StockRepository stockRepository;
	@Autowired
	private ShelfService shelfService;
	@Autowired
	private Depot depotRules;

	public void createStock(Stock stock) {
		// stockRepository.save(stock);

		System.out.println("Modunu al: " + (111 % 5));

		List<Shelf> shelvesMatchingStockId = shelfService.findAllByStockId(stock.getId());
		int howManyShelfNeed = stock.getQuantity() / depotRules.getShelfCapacity(), currentShelfs = 0;
		for (Shelf shelf : shelvesMatchingStockId) {
			currentShelfs += shelf.getOccupiedQuantity();
			System.out.println(shelf);
		}
		// 103-102 gibi raf kapasitesi (5)'e tam bolunmeyen ve arada kalan raf
		// bolmelerini buluyoruz.
		int remainingShelfCapacity = stock.getQuantity() % 5;
		// ekleyecegimiz urun daha once farkli raflarda bulunuyorsa ona gore raf
		// sayimizi ayarlayacagiz
		howManyShelfNeed = howManyShelfNeed - (currentShelfs / 5);

		if (remainingShelfCapacity > 0) {
			howManyShelfNeed++;
		}
		// tam dolu raflar için
		for (int index = 0; index < howManyShelfNeed; index++) {
			Shelf createShelf = new Shelf();
			createShelf.setStockId(stock.getId());

			if (remainingShelfCapacity > 0 && index == howManyShelfNeed - 1) {
				createShelf.setOccupiedQuantity(remainingShelfCapacity);
			} else {
				createShelf.setOccupiedQuantity(5);
			}

			shelfService.createShelf(createShelf);
		}
		System.out.println("Modu alınan arta kalan raf bölmesinin sayisi: " + remainingShelfCapacity);

		System.out.println("Lazim olan raf sayisi: " + howManyShelfNeed);
	}

	public Stock readGpu(int id) {
		Optional<Stock> stock = stockRepository.findById(id);
		return stock.orElseThrow();
	}

	public void updateGpu(int id, Stock stock) {

		Stock currentStock = readGpu(id);
		currentStock = stock;
		createStock(currentStock);

	}

	@Transactional
	public void deleteGpu(int id) {
		stockRepository.deleteById(id);
	}
}