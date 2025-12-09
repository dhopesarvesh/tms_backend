package com.tms.tms_backend.service;


import com.tms.tms_backend.entity.Booking;
import com.tms.tms_backend.enums.BookingStatusType;
import com.tms.tms_backend.repository.BookingRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class BookingService {

    private  final BookingRepository bookingRepository;


    public BookingService(BookingRepository bookingRepository) {
        this.bookingRepository = bookingRepository;
    }

    public Optional<Booking> findBookingById(UUID bookingId){
        return bookingRepository.findById(bookingId);
    }

    public List<Booking> findBookingsByLoadId(UUID loadId){
        return bookingRepository.findByLoadId(loadId);
    }

    public List<Booking> findBookingByTransporterId(UUID transporterId){
        return bookingRepository.findByTransporterId(transporterId);
    }



    @Transactional
    public Booking markBookingCompleted(UUID bookingId){
        Booking booking = bookingRepository.findById(bookingId)
                .orElseThrow(() -> new IllegalArgumentException("Booking NOT Found with Id" + bookingId));

        if(booking.getStatus() == BookingStatusType.CANCELLED){
            throw new IllegalStateException("Cannot complete a cancelled Booking");
        }

        if(booking.getStatus() == BookingStatusType.COMPLETED){
            return booking;
        }

        if(booking.getStatus() != BookingStatusType.CONFIRMED){
            throw new IllegalStateException("Booking must be CONFIRMED to be marked as COMPLETED. Current Status:" + booking.getStatus());

        }

        booking.setStatus(BookingStatusType.COMPLETED);
        return bookingRepository.save(booking);
    }
}
