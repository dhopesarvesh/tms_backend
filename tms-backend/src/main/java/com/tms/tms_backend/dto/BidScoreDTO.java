package com.tms.tms_backend.dto;

import com.tms.tms_backend.entity.Bid;

import java.math.BigDecimal;

public record BidScoreDTO(Bid bid, BigDecimal score) {
}
