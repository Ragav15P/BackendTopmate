package com.Propeers.Ragav.BackendTopmate.service;

import java.time.DayOfWeek;
import java.util.List;

import com.Propeers.Ragav.BackendTopmate.entity.Slot;
import com.Propeers.Ragav.BackendTopmate.entity.User;

public interface SlotService 
{
	Slot createSlot(Slot slot);

    List<Slot> getAllSlots();

    List<Slot> getSlotsByMentor(User mentor);

    List<Slot> getAvailableSlotsByMentor(User mentor);

    List<Slot> getSlotsByMentorAndDay(User mentor, DayOfWeek dayOfWeek);

    Slot updateSlot(Long id, Slot updatedSlot);

    void deleteSlot(Long id);
}
