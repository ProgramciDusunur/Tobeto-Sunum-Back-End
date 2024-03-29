package com.tobeto.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.tobeto.entity.Shelf;

import jakarta.transaction.Transactional;

@Repository
public interface ShelfRepository extends JpaRepository<Shelf, Integer> {
	Optional<Shelf> findById(int id);

	List<Shelf> findAllByStockId(int stockId);

	@Transactional
	@Modifying
	@Query(value = "INSERT INTO Shelf (occupied_quantity, stock_id) VALUES (:occupiedQuantity, :stockId)", nativeQuery = true)
	void insertShelf(@Param("occupiedQuantity") int occupiedQuantity, @Param("stockId") int stockId);

	@Query("SELECT s FROM Shelf s WHERE s.occupiedQuantity > 0 AND s.occupiedQuantity < 5 AND s.stockId = :stockId")
	List<Shelf> findShelvesByOccupiedQuantityAndStockId(@Param("stockId") int stockId);

	@Query("SELECT s FROM Shelf s WHERE s.occupiedQuantity > 0 AND s.stockId = :stockId")
	Shelf findShelfByOccupiedQuantityAndStockId(@Param("stockId") int stockId);

	@Query("SELECT s FROM Shelf s WHERE s.occupiedQuantity > 0 AND s.stockId = :stockId ORDER BY s.occupiedQuantity ASC")
	List<Shelf> findShelvesByOccupiedQuantityAndStockIdOrderByOccupiedQuantityAsc(@Param("stockId") int stockId,
			Pageable pageable);

	List<Shelf> findAllByOccupiedQuantity(int occupiedQuantity);

}