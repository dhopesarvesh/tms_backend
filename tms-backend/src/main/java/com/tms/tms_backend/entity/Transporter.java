package com.tms.tms_backend.entity;


import com.fasterxml.jackson.annotation.JsonTypeId;
import com.tms.tms_backend.dto.TruckAvaibility;

import io.hypersistence.utils.hibernate.type.json.JsonBinaryType;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Type;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "transporter")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Transporter {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID transporterID;

    @NotBlank(message = "Company name must be present")
    @Column(nullable = false, unique = true ,length = 100)
    private String companyName;

    @NotNull(message = "Rating must be present")
    @DecimalMin(value = "1.0", message = "Rating must be 1.0")
    @DecimalMax(value = "5.0", message = "Rating value must be uptil 5.0")
    @Column(nullable = false, precision = 2 ,scale = 1)
    private BigDecimal rating;

    @Type(JsonBinaryType.class)
    @Column(name = "avaiabletrucks_json", columnDefinition = "json", nullable = false)
    private List<TruckAvaibility> availableTrucks;

    @Column(nullable = false, updatable = false)
    private Instant dateJoined = Instant.now();

    @PrePersist
    protected void onCreate() {
        if (this.transporterID == null) {
            this.transporterID = UUID.randomUUID();
        }
        if (this.dateJoined == null) {
            this.dateJoined = Instant.now();
        }
    }





}
