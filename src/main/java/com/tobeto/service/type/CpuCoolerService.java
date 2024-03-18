package com.tobeto.service.type;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tobeto.entity.type.CpuCooler;
import com.tobeto.repository.type.CpuCoolerRepository;

import jakarta.transaction.Transactional;

@Service
public class CpuCoolerService {
	@Autowired
	CpuCoolerRepository cpuCoolerRepository;
	
	public void createCpuCooler(CpuCooler cpucooler) {
		cpuCoolerRepository.save(cpucooler);
	}

	public CpuCooler readCpuCooler(int id) {
		Optional<CpuCooler> cpuCooler = cpuCoolerRepository.findById(id);
		return cpuCooler.orElseThrow();
	}

	public void  updateCpuCooler(int id, CpuCooler cpuCooler) {
		
		CpuCooler currentCpuCooler= readCpuCooler(id);
//		currentCase.setBrand(computerCase.getBrand());
//		currentCase.setModel(computerCase.getModel());
//		currentCase.setPsu(computerCase.isPsu());
//		currentCase.setPsu_location(computerCase.getPsu_location());
//		currentCase.setPsu_watt(computerCase.getPsu_watt());
//		currentCase.setTransparent(computerCase.isTransparent());
//		Bu farklı bir yol
		currentCpuCooler=cpuCooler;
		createCpuCooler(currentCpuCooler);
		
	}

	@Transactional
	public void deleteCpuCooler(int id) {
		cpuCoolerRepository.deleteById(id);
	}
}
