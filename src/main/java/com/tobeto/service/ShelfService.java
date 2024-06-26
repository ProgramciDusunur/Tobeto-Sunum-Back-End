package com.tobeto.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.tobeto.entity.Shelf;
import com.tobeto.repository.ShelfRepository;
import com.tobeto.rules.Depot;

/**
 * Raf işlemlerini yöneten hizmet sınıfı. Bu sınıf, raf veritabanı işlemlerini
 * gerçekleştirir ve depo kurallarını uygular.
 *
 * @author Eren Araz
 */
@Service
public class ShelfService {
	@Autowired
	private ShelfRepository shelfRepository;
	@Autowired
	private Depot depotRules;

	/**
	 * Yeni bir raf oluşturur ve veritabanına ekler.
	 *
	 * @param shelf Oluşturulacak raf.
	 */
	public void createShelf(Shelf shelf) {
		shelfRepository.insertShelf(shelf.getOccupiedQuantity(), shelf.getStockId());
	}

	/**
	 * Belirli bir stok kimliği ile ilişkilendirilmiş tüm rafları bulur.
	 *
	 * @param stockId Stokun kimliği.
	 * @return Belirtilen stok kimliği ile ilişkilendirilmiş tüm rafları içeren bir
	 *         liste.
	 */
	public List<Shelf> findAllByStockId(int stockId) {
		List<Shelf> shelfList = shelfRepository.findAllByStockId(stockId);
		return shelfList;
	}

	/**
	 * Belirli bir stok kimliği ile ilişkilendirilmiş ve dolu miktarı belirli bir
	 * aralıkta olan rafları bulur.
	 *
	 * @param stockId Stokun kimliği.
	 * @return Belirli bir stok kimliği ile ilişkilendirilmiş ve dolu miktarı
	 *         belirli bir aralıkta olan tüm rafları içeren bir liste.
	 */
	public List<Shelf> findAllEmptyShelfFromSpecificStockId(int stockId) {
		return shelfRepository.findShelvesByOccupiedQuantityAndStockId(stockId);
	}

	/**
	 * Dolu olmayan rafları tam dolu hale getirir.
	 *
	 * @param emptyShelfs Dolu olmayan rafların listesi.
	 */
	public void updateEmptyShelfsToFull(List<Shelf> emptyShelfs) {
		for (Shelf shelf : emptyShelfs) {
			shelf.setOccupiedQuantity(depotRules.getShelfCapacity());
			shelfRepository.save(shelf);
		}
	}

	/**
	 * Belirli bir stok için istenilen sayıda dolu raf oluşturur.
	 *
	 * @param howManyShelfNeed       Oluşturulacak raf sayısı.
	 * @param remainingShelfCapacity Kalan raf kapasitesi.
	 * @param stockId                Stokun kimliği.
	 */
	public void createFullShelfs(int howManyShelfNeed, int remainingShelfCapacity, int stockId) {
		// tam dolu raflar için
		for (int index = 0; index < howManyShelfNeed; index++) {
			Shelf createShelf = new Shelf();
			createShelf.setStockId(stockId);

			if (remainingShelfCapacity > 0 && index == howManyShelfNeed - 1) {
				createShelf.setOccupiedQuantity(remainingShelfCapacity);
			} else {
				createShelf.setOccupiedQuantity(depotRules.getShelfCapacity());
			}

			createShelf(createShelf);
		}
	}

	public void findTargetShelfsForDecreaseStockQuantity(int stockId, int howManyShelfPartNeed) {
		int remainingShelfCapacity = howManyShelfPartNeed % depotRules.getShelfCapacity();
		int howManyShelfNeed = howManyShelfPartNeed / depotRules.getShelfCapacity();
		if (remainingShelfCapacity > 0) {
			howManyShelfNeed++;
		}
		// howManyShelfNeed + 1, bir tane raf cekersek istedigimiz quantityden kucuk
		// olabilir, o yuzden ekstra bir tane raf cekiyoruz
		Pageable pageable = PageRequest.of(0, howManyShelfNeed + 1);
		List<Shelf> targetShelfs = shelfRepository
				.findShelvesByOccupiedQuantityAndStockIdOrderByOccupiedQuantityAsc(stockId, pageable);

		for (Shelf shelf : targetShelfs) {
			System.out.println(shelf);
			if (howManyShelfPartNeed - shelf.getOccupiedQuantity() < 0) {
				shelf.setOccupiedQuantity(shelf.getOccupiedQuantity() - howManyShelfPartNeed);
			} else {
				howManyShelfPartNeed -= shelf.getOccupiedQuantity();
				shelf.setOccupiedQuantity(0);
			}
		}

	}

	public List<Shelf> getAllEmptyShelves() {
		return shelfRepository.findAllByOccupiedQuantity(0);
	}

	public void deleteShelfList(List<Shelf> shelfList) {
		shelfRepository.deleteAll(shelfList);
	}

	public List<Shelf> getAllShelves() {
		return shelfRepository.findAll();
	}

	public void removeShelf(int id) {
		shelfRepository.deleteById(id);
	}

}