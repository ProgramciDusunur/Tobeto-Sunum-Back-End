package com.tobeto.service.type;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tobeto.entity.type.Gpu;
import com.tobeto.repository.type.GpuRepository;

import jakarta.transaction.Transactional;

@Service
public class GpuService {
	@Autowired
	GpuRepository gpuRepository;

	public Gpu createGpu(Gpu gpu) {
		return gpuRepository.save(gpu);
	}

	public Gpu readGpu(int id) {
		Optional<Gpu> gpu = gpuRepository.findById(id);
		return gpu.orElseThrow();
	}

	public List<Gpu> readAllGraphicsCards() {
		return gpuRepository.findAll();
	}

	public void updateGpu(int id, Gpu gpu) {
		Gpu currentGpu = readGpu(id);
		currentGpu = gpu;
		createGpu(currentGpu);
	}

	@Transactional
	public void deleteGpu(int id) {
		gpuRepository.deleteById(id);
	}
}
