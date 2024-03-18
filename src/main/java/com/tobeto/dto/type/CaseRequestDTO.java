package com.tobeto.dto.type;

import lombok.Data;

@Data
public class CaseRequestDTO {
    private String brand;
    private boolean psu;
    private String psuLocation;
    private boolean transparent;
    private int psuWatt;
    private String model;
}
