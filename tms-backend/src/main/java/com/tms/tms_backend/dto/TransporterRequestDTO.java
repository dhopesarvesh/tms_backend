package com.tms.tms_backend.dto;

import jakarta.validation.Valid;
import jakarta.validation.constraints.DecimalMax;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.List;
import java.util.UUID;
@Data
public class TransporterRequestDTO {

    @NotBlank(message = "Company Name is required.")
    private String companyName;

    @NotNull(message = "Rating is required.")
    @DecimalMin(value = "0.0", message = "Rating must be between 0.0 and 5.0")
    @DecimalMax(value = "5.0", message = "Rating must be between 0.0 and 5.0")
    private BigDecimal rating;

    @NotNull(message = "Initial truck capacity list is required.")
    @Valid
    private List<TruckAvaibility> availableTrucks;
}
