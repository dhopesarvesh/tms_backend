package com.tms.tms_backend.repository;

import com.tms.tms_backend.entity.Booking;
import com.tms.tms_backend.enums.BookingStatusType;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
import java.util.UUID;

public interface BookingRepository extends JpaRepository<Booking, UUID> {

    List<Booking>  findByLoadIdAndStatus(UUID loadId, BookingStatusType statusType);
    List<Booking> findByLoadId(UUID loadId);
    List<Booking> findByTransporterId(UUID transporterId);
}
