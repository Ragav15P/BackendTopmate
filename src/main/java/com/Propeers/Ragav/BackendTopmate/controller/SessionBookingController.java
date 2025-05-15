package com.Propeers.Ragav.BackendTopmate.controller;

import com.Propeers.Ragav.BackendTopmate.entity.SessionBooking;
import com.Propeers.Ragav.BackendTopmate.entity.Slot;
import com.Propeers.Ragav.BackendTopmate.entity.User;
import com.Propeers.Ragav.BackendTopmate.repo.SlotRepository;
import com.Propeers.Ragav.BackendTopmate.repo.UserRepository;
import com.Propeers.Ragav.BackendTopmate.service.SessionBookingService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

@RestController
@RequestMapping("/api/bookings")
public class SessionBookingController {

    @Autowired
    private SessionBookingService bookingService;

    @Autowired
    private UserRepository userRepo;

    @Autowired
    private SlotRepository slotRepo;

    @PostMapping
    public SessionBooking createBooking(@RequestParam Long menteeId,
                                        @RequestParam Long slotId,
                                        @RequestParam String status,
                                        @RequestParam String paymentStatus) {

        User mentee = userRepo.findById(menteeId)
                .orElseThrow(() -> new RuntimeException("Mentee not found"));

        Slot slot = slotRepo.findById(slotId)
                .orElseThrow(() -> new RuntimeException("Slot not found"));

        SessionBooking booking = new SessionBooking(
                mentee,
                slot,
                LocalDateTime.now(),
                status,
                paymentStatus
        );

        return bookingService.bookSession(booking);
    }
}
