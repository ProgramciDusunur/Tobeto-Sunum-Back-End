package com.tobeto.dto.type;

import lombok.Data;

@Data
public class PsuRequestDTO {
    private int watt;
    private String efficiency;
    private boolean modular;
    private String type;
    private boolean pcieGen5Support;
    private String brand;
    private String model;
}
