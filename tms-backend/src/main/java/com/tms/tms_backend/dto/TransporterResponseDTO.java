package com.tms.tms_backend.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.List;
import java.util.UUID;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class TransporterResponseDTO {


    private String companyName;
    private BigDecimal rating;
    private List<TruckAvaibility> availableTrucks;
    private Instant dateJoined = Instant.now();
}
