package com.tobeto.rules;

import org.springframework.stereotype.Service;

import lombok.Data;

@Service
@Data
public class Depot {
	private int maximumShelf = 100;
	private int shelfCapacity = 5;

}
