package com.tms.tms_backend.dto;

import com.tms.tms_backend.enums.BookingStatusType;
import lombok.Data;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.UUID;
@Data
public class BookingResponseDTO {

    private UUID bookingId;
    private UUID loadId;
    private UUID bidId;
    private UUID transporterId;
    private Integer allocatedTrucks;
    private BigDecimal finalRate;
    private BookingStatusType status = BookingStatusType.CONFIRMED;
    private Instant bookedAt;
}
