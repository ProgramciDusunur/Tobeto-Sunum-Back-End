package com.tobeto.service.type;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tobeto.entity.type.Case;
import com.tobeto.entity.type.Cpu;
import com.tobeto.entity.type.CpuCooler;
import com.tobeto.repository.type.CaseRepository;
import com.tobeto.repository.type.CpuRepository;

import jakarta.transaction.Transactional;

@Service
public class CpuService {
	@Autowired
	CpuRepository cpuRepository;
	
	public void createCpu(Cpu cpu) {
		cpuRepository.save(cpu);
	}

	public Cpu readCpu(int id) {
		Optional<Cpu> cpu = cpuRepository.findById(id);
		return cpu.orElseThrow();
	}
	public void  updateCpu(int id, Cpu cpu) {
		
		Cpu currentCpu= readCpu(id);
//		currentCase.setBrand(computerCase.getBrand());
//		currentCase.setModel(computerCase.getModel());
//		currentCase.setPsu(computerCase.isPsu());
//		currentCase.setPsu_location(computerCase.getPsu_location());
//		currentCase.setPsu_watt(computerCase.getPsu_watt());
//		currentCase.setTransparent(computerCase.isTransparent());
//		Bu farklı bir yol
		currentCpu=cpu;
		createCpu(currentCpu);
		
	}

	@Transactional
	public void deleteCpu(int id) {
		cpuRepository.deleteById(id);
	}
}
