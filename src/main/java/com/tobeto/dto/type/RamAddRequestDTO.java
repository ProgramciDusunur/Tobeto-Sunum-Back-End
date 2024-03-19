package com.tobeto.dto.type;

import lombok.Data;

@Data
public class RamAddRequestDTO {
    private String type;
    private int capacity;
    private int frequencySpeed;
    private String channelType;
    private String compatibility;
    private String brand;
    private String model;
}
