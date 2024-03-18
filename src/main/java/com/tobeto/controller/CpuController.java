package com.tobeto.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tobeto.entity.type.Gpu;

@RestController
@RequestMapping("/api/v1/type/cpu")
public class CpuController {

	@PostMapping("/add")
	public void addSubType(@RequestBody Object subType) {
		System.out.println("Cpu Post calisiyor.");
		
	}
}
