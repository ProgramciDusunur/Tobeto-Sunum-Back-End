package com.tobeto.service.type;

import java.util.List;
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

	public Motherboard createMotherboard(Motherboard motherboard) {
		return motherboardRepository.save(motherboard);
	}

	public Motherboard readMotherboard(int id) {
		Optional<Motherboard> cpu = motherboardRepository.findById(id);
		return cpu.orElseThrow();
	}

	public List<Motherboard> readAllMotherboard() {
		return motherboardRepository.findAll();
	}

	public void updateMotherboard(int id, Motherboard motherboard) {
		Motherboard currentMotherboard = readMotherboard(id);
		currentMotherboard = motherboard;
		createMotherboard(currentMotherboard);
	}

	@Transactional
	public void deleteMotherboard(int id) {
		motherboardRepository.deleteById(id);
	}
}
