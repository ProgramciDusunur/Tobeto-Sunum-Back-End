package com.tobeto.service.type;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tobeto.entity.type.Psu;
import com.tobeto.repository.type.PsuRepository;

import jakarta.transaction.Transactional;

@Service
public class PsuService {
	@Autowired
	PsuRepository psuRepository;

	public Psu createPsu(Psu psu) {
		return psuRepository.save(psu);
	}

	public Psu readPsu(int id) {
		Optional<Psu> psu = psuRepository.findById(id);
		return psu.orElseThrow();
	}

	public List<Psu> readAllPsu() {
		return psuRepository.findAll();
	}

	public void updatePsu(int id, Psu psu) {
		Psu currentPsu = readPsu(id);
		currentPsu = psu;
		createPsu(currentPsu);
	}

	@Transactional
	public void deletePsu(int id) {
		psuRepository.deleteById(id);
	}
}
