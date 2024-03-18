package com.tobeto.controller.type;

import com.tobeto.dto.type.GpuRequestDTO;
import com.tobeto.dto.type.GpuResponseDTO;
import com.tobeto.dto.type.MotherboardRequestDTO;
import com.tobeto.dto.type.MotherboardResponseDTO;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value ="/api/v1/type/motherboard")
public class MotherboardController {

    @PostMapping(value = "/add", consumes = MediaType.APPLICATION_JSON_VALUE)
    public MotherboardResponseDTO addSubType(@RequestBody MotherboardRequestDTO dto) {
        System.out.println("Motherboard Post calisiyor.");
        System.out.println(dto.getBrand());
        System.out.println(dto.getModel());
        System.out.println(dto.getSize());
        System.out.println(dto.getRamType());
        System.out.println(dto.getCpuSocketType());
        System.out.println(dto.getRamSlots());

        // System.out.println(dto.getModel());
        return new MotherboardResponseDTO();

    }
}
