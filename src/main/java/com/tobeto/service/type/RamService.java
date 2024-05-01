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

	public Ram createRam(Ram ram) {
		return ramRepository.save(ram);
	}

	public Ram readRam(int id) {
		Optional<Ram> ram = ramRepository.findById(id);
		return ram.orElseThrow();
	}

	public void updateRam(int id, Ram ram) {
		Ram currentRam = readRam(id);
		currentRam = ram;
		createRam(currentRam);
	}

	@Transactional
	public void deleteRam(int id) {
		ramRepository.deleteById(id);
	}
}