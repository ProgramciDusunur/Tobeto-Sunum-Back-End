package com.tobeto.dto.type;

import lombok.Data;

@Data
public class CpuAddRequestDTO {
    private String brand;
    private int clockSpeed;
    private String socketType;
    private String generation;
    private String series;
    private int coreCount;
    private String model;
}
