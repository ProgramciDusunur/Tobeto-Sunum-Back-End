package com.tobeto.dto.type.psu;

import lombok.Data;

@Data
public class PsuPutRequestDTO {
    private int id;
    private int watt;
    private String efficiency;
    private boolean modular;
    private String type;
    private boolean pcieGen5Support;
    private String brand;
    private String model;

}
