package com.Propeers.Ragav.BackendTopmate.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Propeers.Ragav.BackendTopmate.entity.SessionBooking;
import com.Propeers.Ragav.BackendTopmate.entity.User;
import com.Propeers.Ragav.BackendTopmate.repo.SessionBookingRepository;

@Service
public class SessionBookingServiceImplementation implements SessionBookingService {

    @Autowired
    private SessionBookingRepository bookingRepo;

    @Override
    public SessionBooking bookSession(SessionBooking sessionBooking) {
        return bookingRepo.save(sessionBooking);
    }

    @Override
    public List<SessionBooking> getAllBookings() {
        return bookingRepo.findAll();
    }

    @Override
    public List<SessionBooking> getBookingsByMentee(User mentee) {
        return bookingRepo.findByMentee(mentee);
    }

    @Override
    public SessionBooking updateBooking(Long id, SessionBooking updatedBooking) {
        SessionBooking existingBooking = bookingRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Booking not found"));

        // Use correct setter name: setSlot, not setSessionSlot
        existingBooking.setSlot(updatedBooking.getSlot());
        existingBooking.setStatus(updatedBooking.getStatus());
        existingBooking.setPaymentStatus(updatedBooking.getPaymentStatus());

        return bookingRepo.save(existingBooking);
    }


    @Override
    public void cancelBooking(Long id) {
        bookingRepo.deleteById(id);
    }
}
