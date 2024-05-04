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

	@Transactional
	public void createStock(Stock stock) {
		/*
		 * try { // Block of code to try } catch (Exception e) { // Block of code to
		 * handle errors }
		 */
		// burasi tekrardan kontrol icin duzenlenecek
		stockRepository.insertStock(stock.getType(), stock.getQuantity(), stock.getTypeId());
		Optional<Stock> addAndGetStockId = stockRepository.findStockByTypeAndTypeId(stock.getType(), stock.getTypeId());
		int stockId = addAndGetStockId.get().getId();
		int howManyShelfNeed = stock.getQuantity() / depotRules.getShelfCapacity(), currentShelfs = 0,
				emptyShelfParts = 0;
		// stock_idsi eslesen ve yeri olan raflari bul.
		List<Shelf> emptyShelfs = shelfService.findAllEmptyShelfFromSpecificStockId(stockId);
		// stock_id ile eslesmis ve occupied_quantity > 0 ve occupied_quantity < 5 olan
		// bos raflari guncelleyip, dolduruyor.
		updateEmptyShelfs(emptyShelfs);
		for (Shelf shelf : emptyShelfs) {
			System.out.println(shelf);
			emptyShelfParts += depotRules.getShelfCapacity() - shelf.getOccupiedQuantity();
		}
		// bos raflari doldurduktan sonra ihtiyacimiz olan raf sayisini guncelliyoruz.
		howManyShelfNeed = (howManyShelfNeed) - (emptyShelfParts * 5);
		List<Shelf> shelvesMatchingStockId = shelfService.findAllByStockId(stockId);
		// eger Stock verisinde quantitye kisisel bir mudahele oldu ise hali hazirda
		// olan raflari buluyoruz.
		for (Shelf shelf : shelvesMatchingStockId) {
			currentShelfs += shelf.getOccupiedQuantity();
			System.out.println(shelf);
		}
		// 103-102 gibi raf kapasitesi (5)'e tam bolunmeyen ve arada kalan raf
		// bolmelerini buluyoruz.
		int remainingShelfCapacity = stock.getQuantity() % depotRules.getShelfCapacity();
		// ekleyecegimiz urun daha once farkli raflarda bulunuyorsa ona gore raf
		// sayimizi ayarlayacagiz
		howManyShelfNeed = howManyShelfNeed - (currentShelfs / depotRules.getShelfCapacity());
		// 5 den kucuk bolmeden kalan raf bolmesi sifirdan buyukse ekstra bir raf daha
		// acmamiz gerek.
		if (remainingShelfCapacity > 0) {
			howManyShelfNeed++;
		}
		// tam dolu raflarimizi olusturduktan sonra en sonda eger ekstradan 0 dan buyuk
		// ve 5 den kucuk bir ekstra alanimiz varsa onun icin raf ekliyoruz.
		shelfService.createFullShelfs(howManyShelfNeed, remainingShelfCapacity, stockId);
	}

	public void updateEmptyShelfs(List<Shelf> emptyShelfs) {
		shelfService.updateEmptyShelfsToFull(emptyShelfs);
	}

	public Stock readStock(int id) {
		Optional<Stock> stock = stockRepository.findById(id);
		return stock.orElseThrow();
	}

	public void updateStock(int id, int quantity) {
		Stock currentStock = readStock(id);
		currentStock.setQuantity(quantity);
		stockRepository.save(currentStock);
	}

	public List<Stock> findAllStocks() {
		return stockRepository.findAll();
	}

	public void decreaseStockQuantity(int id, int quantity) {
		Stock currentStock = readStock(id);
		shelfService.findTargetShelfsForDecreaseStockQuantity(currentStock.getId(), quantity);

		if (currentStock.getQuantity() - quantity < 0) {
			currentStock.setQuantity(0);
		} else {
			currentStock.setQuantity(currentStock.getQuantity() - quantity);
		}
		stockRepository.save(currentStock);

	}

	@Transactional
	public void deleteStock(int id) {
		Stock targetStock = readStock(id);
		decreaseStockQuantity(id, targetStock.getQuantity());
		stockRepository.deleteById(id);
	}
}