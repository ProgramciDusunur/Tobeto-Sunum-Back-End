package com.tobeto.service.type;

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
	
	public void createGpu(Gpu gpu) {
		gpuRepository.save(gpu);
	}

	public Gpu readGpu(int id) {
		Optional<Gpu> gpu = gpuRepository.findById(id);
		return gpu.orElseThrow();
	}
	public void  updateGpu(int id, Gpu gpu) {
		
		Gpu currentGpu= readGpu(id);
//		currentCase.setBrand(computerCase.getBrand());
//		currentCase.setModel(computerCase.getModel());
//		currentCase.setPsu(computerCase.isPsu());
//		currentCase.setPsu_location(computerCase.getPsu_location());
//		currentCase.setPsu_watt(computerCase.getPsu_watt());
//		currentCase.setTransparent(computerCase.isTransparent());
//		Bu farklı bir yol
		currentGpu=gpu;
		createGpu(currentGpu);
		
	}

	@Transactional
	public void deleteGpu(int id) {
		gpuRepository.deleteById(id);
	}
}
