package com.tms.tms_backend.dto;

import com.tms.tms_backend.enums.BidStatusType;
import lombok.Data;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.UUID;
@Data
public class BidRequestDTO {
    private UUID bidID;
    private UUID loadId;
    private UUID transporterId;
    private BigDecimal proposedRate;
    private Integer trucksOffered;
    private BidStatusType status = BidStatusType.PENDING;
    private Instant submittedAt;
}
