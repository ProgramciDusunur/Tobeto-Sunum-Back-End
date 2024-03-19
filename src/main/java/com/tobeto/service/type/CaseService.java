package com.tobeto.service.type;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import com.tobeto.entity.type.Case;
import com.tobeto.repository.type.CaseRepository;

import jakarta.transaction.Transactional;
import lombok.Data;


@Service
@Data
public class CaseService {
	@Autowired
	CaseRepository caseRepository;
	
	public void createCase(Case computerCase) {
		caseRepository.save(computerCase);
	}

	public Case readCase(int id) {
		Optional<Case> computerCase = caseRepository.findById(id);
		return computerCase.orElseThrow();
	}

	public void  updateCase(int id, Case computerCase) {
		
		Case currentCase= readCase(id);
//		currentCase.setBrand(computerCase.getBrand());
//		currentCase.setModel(computerCase.getModel());
//		currentCase.setPsu(computerCase.isPsu());
//		currentCase.setPsu_location(computerCase.getPsu_location());
//		currentCase.setPsu_watt(computerCase.getPsu_watt());
//		currentCase.setTransparent(computerCase.isTransparent());
//		Bu farklı bir yol
		currentCase=computerCase;
		createCase(currentCase);
		
	}

	@Transactional
	public void deleteCase(int id) {
		caseRepository.deleteById(id);
	}
}
