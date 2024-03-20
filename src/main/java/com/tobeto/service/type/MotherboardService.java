package com.tobeto.service.type;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tobeto.entity.type.Motherboard;
import com.tobeto.repository.type.MotherboardRepository;

import jakarta.transaction.Transactional;

@Service
public class MotherboardService {
	@Autowired
	MotherboardRepository motherboardRepository;

	public void createMotherboard(Motherboard motherboard) {
		motherboardRepository.save(motherboard);
	}

	public Motherboard readMotherboard(int id) {
		Optional<Motherboard> cpu = motherboardRepository.findById(id);
		return cpu.orElseThrow();
	}

	public void updateMotherboard(int id, Motherboard motherboard) {

		Motherboard currentMotherboard = readMotherboard(id);
//		currentCase.setBrand(computerCase.getBrand());
//		currentCase.setModel(computerCase.getModel());
//		currentCase.setPsu(computerCase.isPsu());
//		currentCase.setPsu_location(computerCase.getPsu_location());
//		currentCase.setPsu_watt(computerCase.getPsu_watt());
//		currentCase.setTransparent(computerCase.isTransparent());
//		Bu farklı bir yol
		currentMotherboard = motherboard;
		createMotherboard(currentMotherboard);

	}

	@Transactional
	public void deleteMotherboard(int id) {
		motherboardRepository.deleteById(id);
	}
}
