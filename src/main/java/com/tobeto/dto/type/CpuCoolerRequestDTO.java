package com.tobeto.dto.type;

import lombok.Data;

@Data
public class CpuCoolerRequestDTO {
    private String type;
    private String fanLength;
    private int rpm;
    private String material;
    private String led;
    private String brand;
    private String model;
}
