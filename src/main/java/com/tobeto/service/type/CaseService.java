package com.tobeto.service.type;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tobeto.entity.type.DesktopCase;
import com.tobeto.repository.type.CaseRepository;

import jakarta.transaction.Transactional;
import lombok.Data;

@Service
@Data
public class CaseService {
	@Autowired
	CaseRepository caseRepository;

	public void createDesktopCase(DesktopCase computerCase) {
		caseRepository.save(computerCase);
	}

	public DesktopCase readDesktopCase(int id) {
		Optional<DesktopCase> computerCase = caseRepository.findById(id);
		return computerCase.orElseThrow();
	}

	public void updateDesktopCase(int id, DesktopCase computerCase) {

		DesktopCase currentCase = readDesktopCase(id);
//		currentCase.setBrand(computerCase.getBrand());
//		currentCase.setModel(computerCase.getModel());
//		currentCase.setPsu(computerCase.isPsu());
//		currentCase.setPsu_location(computerCase.getPsu_location());
//		currentCase.setPsu_watt(computerCase.getPsu_watt());
//		currentCase.setTransparent(computerCase.isTransparent());
//		Bu farklı bir yol
		currentCase = computerCase;
		createDesktopCase(currentCase);

	}

	@Transactional
	public void deleteCase(int id) {
		caseRepository.deleteById(id);
	}
}
