package com.tobeto.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tobeto.entity.Psu;

import com.tobeto.repository.PsuRepository;

import jakarta.transaction.Transactional;

@Service
public class PsuService {
	@Autowired
	PsuRepository psuRepository;
	
	public void createPsu(Psu psu) {
		psuRepository.save(psu);
	}

	public Psu readPsu(int id) {
		Optional<Psu> psu = psuRepository.findById(id);
		return psu.orElseThrow();
	}
	public void  updatePsu(int id, Psu psu) {
		
		Psu currentPsu= readPsu(id);
//		currentCase.setBrand(computerCase.getBrand());
//		currentCase.setModel(computerCase.getModel());
//		currentCase.setPsu(computerCase.isPsu());
//		currentCase.setPsu_location(computerCase.getPsu_location());
//		currentCase.setPsu_watt(computerCase.getPsu_watt());
//		currentCase.setTransparent(computerCase.isTransparent());
//		Bu farklı bir yol
		currentPsu=psu;
		createPsu(currentPsu);
		
	}

	@Transactional
	public void deletePsu(int id) {
		psuRepository.deleteById(id);
	}
}
