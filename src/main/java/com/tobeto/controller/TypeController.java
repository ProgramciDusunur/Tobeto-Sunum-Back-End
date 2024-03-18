package com.tobeto.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tobeto.entity.type.Case;

@RestController
@RequestMapping("/api/v1/type")
public class TypeController {

	@PostMapping("/add")
	public void addSubType(@RequestBody Object subType) {
		if (subType.getClass() == Case.class) {
			System.out.println("Case sinifi");
		}
	}
}
