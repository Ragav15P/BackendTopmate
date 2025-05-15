package com.Propeers.Ragav.BackendTopmate.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Propeers.Ragav.BackendTopmate.entity.SessionBooking;
import com.Propeers.Ragav.BackendTopmate.entity.User;

public interface SessionBookingRepository extends JpaRepository<SessionBooking, Long> {
    
    // Get all bookings for a specific mentee
    List<SessionBooking> findByMentee(User mentee);
    
    // Optional: In future, we can add methods like findByStatus or findByPaymentStatus
}
