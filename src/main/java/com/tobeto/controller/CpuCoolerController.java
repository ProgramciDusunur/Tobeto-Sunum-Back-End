package com.tobeto.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/type/cpucooler")
public class CpuCoolerController {

	@PostMapping("/add")
	public void addSubType(@RequestBody Object subType) {
		System.out.println("CpuCooler Post calisiyor.");

	}
}
