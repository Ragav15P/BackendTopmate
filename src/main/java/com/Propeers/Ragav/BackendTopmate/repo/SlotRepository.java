package com.Propeers.Ragav.BackendTopmate.repo;

import java.time.DayOfWeek;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Propeers.Ragav.BackendTopmate.entity.Slot;
import com.Propeers.Ragav.BackendTopmate.entity.User;

public interface SlotRepository extends JpaRepository<Slot,Long>
{
	List<Slot> findByMentor(User mentor);

    // Find slots by mentor and day
    List<Slot> findByMentorAndDayOfWeek(User mentor, DayOfWeek dayOfWeek);

    // Find available (not booked) slots
    List<Slot> findByMentorAndIsBookedFalse(User mentor);
}
