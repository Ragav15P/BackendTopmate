package com.Propeers.Ragav.BackendTopmate.controller;

import com.Propeers.Ragav.BackendTopmate.entity.Slot;
import com.Propeers.Ragav.BackendTopmate.entity.User;
import com.Propeers.Ragav.BackendTopmate.service.SlotService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.DayOfWeek;
import java.util.List;

@RestController
@RequestMapping("/slots")
public class SlotController {

	@Autowired
    private  SlotService slotService;

//    @Autowired
//    public SlotController(SlotService slotService) {
//        this.slotService = slotService;
//    }

    // Get all slots
    @GetMapping
    public ResponseEntity<List<Slot>> getAllSlots() {
        List<Slot> allSlots = slotService.getAllSlots();
        return ResponseEntity.ok(allSlots);
    }

    // Get all available slots for a mentor
    @GetMapping("/available/{mentorId}")
    public ResponseEntity<List<Slot>> getAvailableSlotsByMentor(@PathVariable Long mentorId) {
        User mentor = new User();
        mentor.setId(mentorId);  // Find the mentor by ID or handle user fetching logic
        List<Slot> availableSlots = slotService.getAvailableSlotsByMentor(mentor);
        return ResponseEntity.ok(availableSlots);
    }

    // Get all slots for a mentor on a specific day
    @GetMapping("/by-day/{mentorId}/{dayOfWeek}")
    public ResponseEntity<List<Slot>> getSlotsByMentorAndDay(@PathVariable Long mentorId, @PathVariable DayOfWeek dayOfWeek) {
        User mentor = new User();
        mentor.setId(mentorId);  // Find the mentor by ID or handle user fetching logic
        List<Slot> slots = slotService.getSlotsByMentorAndDay(mentor, dayOfWeek);
        return ResponseEntity.ok(slots);
    }

    // Update a slot's details
    @PutMapping("/{slotId}")
    public ResponseEntity<Slot> updateSlot(@PathVariable Long slotId, @RequestBody Slot updatedSlot) {
        Slot updatedSlotResponse = slotService.updateSlot(slotId, updatedSlot);
        return ResponseEntity.ok(updatedSlotResponse);
    }

    // Create a new slot
    @PostMapping
    public ResponseEntity<Slot> createSlot(@RequestBody Slot newSlot) {
        Slot createdSlot = slotService.createSlot(newSlot);
        return ResponseEntity.status(201).body(createdSlot);
    }

    // Delete a slot by ID
    @DeleteMapping("/{slotId}")
    public ResponseEntity<Void> deleteSlot(@PathVariable Long slotId) {
        slotService.deleteSlot(slotId);
        return ResponseEntity.noContent().build();
    }
}
