package com.tms.tms_backend.entity;


import com.tms.tms_backend.enums.BookingStatusType;
import jakarta.persistence.*;
import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.UUID;

@Entity
@Table(name = "bookings",
        uniqueConstraints = {

                @UniqueConstraint(columnNames = {"loadId"}),

                @UniqueConstraint(columnNames = {"bidId"})
        }
)

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Booking {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID bookingId;

    @NotNull(message = "Load ID is required")
    @Column(nullable = false)
    private UUID loadId;

    @NotNull(message = "Bid ID is required")
    @Column(nullable = false)
    private UUID bidId;

    @NotNull(message = "Transporter ID is required")
    @Column(nullable = false)
    private UUID transporterId;

    @NotNull(message = "Allocated truck count is required")
    @Min(value = 1, message = "At least one truck must be allocated")
    @Column(nullable = false)
    private Integer allocatedTrucks;


    @NotNull(message = "Final rate is required")
    @Positive(message = "Final rate must be greater than zero")
    @Digits(integer = 8, fraction = 2, message = "Rate must be a valid monetary value")
    @Column(nullable = false, precision = 10, scale = 2)
    private BigDecimal finalRate;


    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private BookingStatusType status = BookingStatusType.CONFIRMED;

    @Column(nullable = false, updatable = false)
    private Instant bookedAt;


    @PrePersist
    protected void onCreate() {
        if (this.bookingId == null) {
            this.bookingId = UUID.randomUUID();
        }
        if (this.bookedAt == null) {
            this.bookedAt = Instant.now();
        }
    }
}
