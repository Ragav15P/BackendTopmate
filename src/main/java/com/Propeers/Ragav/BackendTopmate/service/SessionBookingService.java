package com.Propeers.Ragav.BackendTopmate.service;

import java.util.List;

import com.Propeers.Ragav.BackendTopmate.entity.SessionBooking;
import com.Propeers.Ragav.BackendTopmate.entity.User;

public interface SessionBookingService {

    SessionBooking bookSession(SessionBooking sessionBooking);

    List<SessionBooking> getAllBookings();

    List<SessionBooking> getBookingsByMentee(User mentee);

    SessionBooking updateBooking(Long id, SessionBooking updatedBooking);

    void cancelBooking(Long id);
}
