package com.tms.tms_backend.service;


import com.tms.tms_backend.entity.Bid;
import com.tms.tms_backend.enums.BidStatusType;
import com.tms.tms_backend.repository.BidRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class BidService {


    private final BidRepository bidRepository;

    public BidService(BidRepository bidRepository) {
        this.bidRepository = bidRepository;
    }

    public Optional<Bid> findBidById(UUID bidId){
        return bidRepository.findById(bidId);
    }


    @Transactional
    public Bid rejectBid(UUID bidId){
        Bid bid = bidRepository.findById(bidId)
                .orElseThrow(()-> new IllegalArgumentException("Bid not found with ID" + bidId));

        if(bid.getStatus() != BidStatusType.PENDING){
            throw new IllegalStateException("Only PENDING Bids can be rejected Current status " + bid.getStatus());
        }

        bid.setStatus(BidStatusType.REJECTED);
        return bidRepository.save(bid);
    }
}
