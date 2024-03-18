package com.tobeto.dto.type;

import lombok.Data;

@Data
public class MotherboardRequestDTO {
    private String cpuSocketType;
    private boolean cpuCompatibility;
    private String ramType;
    private String size;
    private int ramSlots;
    private String brand;
    private String model;
}
