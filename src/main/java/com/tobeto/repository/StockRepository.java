package com.tobeto.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.tobeto.entity.Stock;

import jakarta.transaction.Transactional;

@Repository
public interface StockRepository extends JpaRepository<Stock, Integer> {
	List<Stock> findAllByOrderById();

	Optional<Stock> findStockByTypeAndTypeId(String type, int typeId);

	@Transactional
	@Modifying
	@Query(value = "INSERT INTO Stock (type, quantity, type_id) VALUES (:type, :quantity, :typeId)", nativeQuery = true)
	void insertStock(@Param("type") String type, @Param("quantity") int quantity, @Param("typeId") int typeId);
}
