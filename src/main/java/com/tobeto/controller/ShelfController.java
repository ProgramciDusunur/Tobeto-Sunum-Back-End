package com.tobeto.controller;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.tobeto.dto.SuccessResponseDTO;
import com.tobeto.dto.shelf.ShelfAddRequestDTO;
import com.tobeto.dto.shelf.ShelfDelRequestDTO;
import com.tobeto.dto.shelf.ShelfGetAllResponseDTO;
import com.tobeto.entity.Shelf;
import com.tobeto.service.ShelfService;

@RestController
@RequestMapping("/api/v1/shelf")
public class ShelfController {
	@Autowired
	private ShelfService shelfService;

	@Autowired
	@Qualifier("requestMapper")
	private ModelMapper requestMapper;
	@Autowired
	@Qualifier("responseMapper")
	private ModelMapper responseMapper;

	@PostMapping("/add")
	public SuccessResponseDTO addShelf(@RequestBody ShelfAddRequestDTO dto) {
		Shelf shelf = requestMapper.map(dto, Shelf.class);
		shelfService.createShelf(shelf);
		return new SuccessResponseDTO();
	}

	@DeleteMapping("/del")
	public void delShelf(@RequestBody ShelfDelRequestDTO dto) {
		List<Shelf> bosRaflar = shelfService.getAllEmptyShelves();
		List<Integer> silinmekIstenenIdler = dto.getShelfIdList();
		List<Shelf> silinecekRaflar = new ArrayList<>();
		for (Shelf shelf : bosRaflar) {
			if (silinmekIstenenIdler.contains(shelf.getId())) {
				// System.out.println(shelf.getId() + " Numarali id silinmek isteniyor.");
				silinecekRaflar.add(shelf);
			}
			// System.out.println(shelf);
		}
		shelfService.deleteShelfList(silinecekRaflar);
	}

	@GetMapping("/get/all")
	public ResponseEntity<String> getAllShelves() {
		System.out.println("Raflarin tumunu alma basarili");
		ShelfGetAllResponseDTO response = new ShelfGetAllResponseDTO();
		List<Shelf> allShelves = shelfService.getAllShelves();
		response.setAllAvailableShelves(allShelves);

		// ObjectMapper kullanarak JSON'a dönüştürme (daha kolay kullanım için)
		ObjectMapper objectMapper = new ObjectMapper();
		String jsonResponse = "";
		try {
			jsonResponse = objectMapper.writeValueAsString(allShelves);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}

		return new ResponseEntity<>(jsonResponse, HttpStatus.OK);
	}

}