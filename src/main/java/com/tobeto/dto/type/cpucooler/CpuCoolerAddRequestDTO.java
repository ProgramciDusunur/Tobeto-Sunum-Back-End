package com.tobeto.dto.type.cpucooler;

import lombok.Data;

@Data
public class CpuCoolerAddRequestDTO {
    private String type;
    private String fanLength;
    private int rpm;
    private String material;
    private String led;
    private String brand;
    private String model;

}
