package com.tms.tms_backend.dto;

import java.math.BigDecimal;

import lombok.Data;

@Data
public class LoadResponseDTO {
    private String shipperId;
    private String loadingCity;
    private String unloadingCity;
    private String loadingDate;
    private String productType;
    private BigDecimal weight;
    private String weightUnit;
    private String truckType;
    private String remainingTrucks;
}
