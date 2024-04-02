package com.tobeto.dto.shelf;

import java.util.List;

import com.tobeto.entity.Shelf;

import lombok.Data;

@Data
public class ShelfGetAllResponseDTO {
	private List<Shelf> allAvailableShelves;

}