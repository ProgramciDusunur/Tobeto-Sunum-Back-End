package com.tobeto.service.type;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tobeto.entity.type.Ram;
import com.tobeto.repository.type.RamRepository;

import jakarta.transaction.Transactional;

@Service
public class RamService {
	@Autowired
	RamRepository ramRepository;

	public void createRam(Ram ram) {
		ramRepository.save(ram);
	}

	public Ram readRam(int id) {
		Optional<Ram> ram = ramRepository.findById(id);
		return ram.orElseThrow();
	}

	public void updateRam(int id, Ram ram) {

		Ram currentRam = readRam(id);
//		currentCase.setBrand(computerCase.getBrand());
//		currentCase.setModel(computerCase.getModel());
//		currentCase.setPsu(computerCase.isPsu());
//		currentCase.setPsu_location(computerCase.getPsu_location());
//		currentCase.setPsu_watt(computerCase.getPsu_watt());
//		currentCase.setTransparent(computerCase.isTransparent());
//		Bu farklı bir yol
		currentRam = ram;
		createRam(currentRam);

	}

	@Transactional
	public void deleteRam(int id) {
		ramRepository.deleteById(id);
	}
}