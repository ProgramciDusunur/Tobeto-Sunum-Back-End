package com.tobeto.service.type;

import java.util.List;
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

	public CpuCooler createCpuCooler(CpuCooler cpucooler) {
		return cpuCoolerRepository.save(cpucooler);
	}

	public CpuCooler readCpuCooler(int id) {
		Optional<CpuCooler> cpuCooler = cpuCoolerRepository.findById(id);
		return cpuCooler.orElseThrow();
	}

	public List<CpuCooler> readAllCpuCoolers() {
		return cpuCoolerRepository.findAll();
	}

	public void updateCpuCooler(int id, CpuCooler cpuCooler) {
		CpuCooler currentCpuCooler = readCpuCooler(id);
		currentCpuCooler = cpuCooler;
		createCpuCooler(currentCpuCooler);
	}

	@Transactional
	public void deleteCpuCooler(int id) {
		cpuCoolerRepository.deleteById(id);
	}
}
