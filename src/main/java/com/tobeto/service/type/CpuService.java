package com.tobeto.service.type;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tobeto.entity.type.Cpu;
import com.tobeto.repository.type.CpuRepository;

import jakarta.transaction.Transactional;

@Service
public class CpuService {
	@Autowired
	CpuRepository cpuRepository;

	public Cpu createCpu(Cpu cpu) {
		return cpuRepository.save(cpu);
	}

	public Cpu readCpu(int id) {
		Optional<Cpu> cpu = cpuRepository.findById(id);
		return cpu.orElseThrow();
	}

	public List<Cpu> readAllCpus() {
		return cpuRepository.findAll();
	}

	public void updateCpu(int id, Cpu cpu) {
		Cpu currentCpu = readCpu(id);
		currentCpu = cpu;
		createCpu(currentCpu);
	}

	@Transactional
	public void deleteCpu(int id) {
		cpuRepository.deleteById(id);
	}
}
