package com.Propeers.Ragav.BackendTopmate.service;

import java.time.DayOfWeek;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Propeers.Ragav.BackendTopmate.entity.Slot;
import com.Propeers.Ragav.BackendTopmate.entity.User;
import com.Propeers.Ragav.BackendTopmate.repo.SlotRepository;

@Service
public class SlotServiceImplementation implements SlotService {

    @Autowired
    private SlotRepository slotrepo;

	@Override
	public Slot createSlot(Slot slot) {
		// TODO Auto-generated method stub
		return slotrepo.save(slot);
	}

	@Override
	public List<Slot> getAllSlots() {
		// TODO Auto-generated method stub
		return slotrepo.findAll();
	}

	@Override
	public List<Slot> getSlotsByMentor(User mentor) {
		// TODO Auto-generated method stub
		return slotrepo.findByMentor(mentor);
	}

	@Override
	public List<Slot> getAvailableSlotsByMentor(User mentor) {
		// TODO Auto-generated method stub
		return slotrepo.findByMentor(mentor)
                .stream()
                .filter(slot -> !slot.isBooked())  // available = not booked
                .collect(Collectors.toList());
	}

	@Override
	public List<Slot> getSlotsByMentorAndDay(User mentor, DayOfWeek dayOfWeek) {
		// TODO Auto-generated method stub
		return slotrepo.findByMentor(mentor)
                .stream()
                .filter(slot -> slot.getDayOfWeek() == dayOfWeek)
                .collect(Collectors.toList());
	}

	@Override
	public Slot updateSlot(Long id, Slot updatedSlot) {
		// TODO Auto-generated method stub
		Slot existingSlot = slotrepo.findById(id).orElseThrow(() -> new RuntimeException("Slot not found"));

        // Check if the slot is already booked, if it is, we cannot update it
        if (existingSlot.isBooked()) {
            throw new IllegalStateException("Cannot update a booked slot");
        }

        // Now update the slot with the new details (assuming you can modify day, time, etc.)
        existingSlot.setDayOfWeek(updatedSlot.getDayOfWeek());
        existingSlot.setStartTime(updatedSlot.getStartTime());
        existingSlot.setEndTime(updatedSlot.getEndTime());
        existingSlot.setBooked(updatedSlot.isBooked()); // Set the booked status if needed

        // Save the updated slot back to the repository
        return slotrepo.save(existingSlot);
	}

	@Override
	public void deleteSlot(Long id) {
		// TODO Auto-generated method stub
		
		slotrepo.deleteById(id);
		
	}

	
    
}
