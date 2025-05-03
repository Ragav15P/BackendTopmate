package com.Propeers.Ragav.BackendTopmate.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Propeers.Ragav.BackendTopmate.dto.StatusUpdateRequest;
import com.Propeers.Ragav.BackendTopmate.entity.MentorRequest;
import com.Propeers.Ragav.BackendTopmate.entity.MentorStatus;
import com.Propeers.Ragav.BackendTopmate.service.MentorInterface;

@RestController
@RequestMapping("/mentor-requests")
public class MentorController 
{
  @Autowired
  private MentorInterface mir;
     
  
  @PostMapping("/{userId}")
  public ResponseEntity<MentorRequest> createMentorRequest(@PathVariable Long userId) {
      MentorRequest mentorRequest = mir.createMentorRequest(userId);
      if (mentorRequest != null) {
          return ResponseEntity.ok(mentorRequest);
      }
      return ResponseEntity.badRequest().build();
      
      
  }
  
  
//  @PatchMapping("/{requestId}/status")
//  public ResponseEntity<MentorRequest> updateMentorRequestStatus(@PathVariable Long requestId,
//                                                                 @RequestBody MentorStatus status) {
//      MentorRequest mentorRequest = mir.updateMentorRequestStatus(requestId, status);
//      if (mentorRequest != null) {
//          return ResponseEntity.ok(mentorRequest);
//      }
//      return ResponseEntity.badRequest().build();
//  }
  
  
  
//  @PatchMapping("/{id}/status")
//  public ResponseEntity<?> updateRequestStatus(
//      @PathVariable Long id,
//      @RequestBody Map<String, String> requestBody
//  ) {
//      try {
//          String statusText = requestBody.get("status");
//          MentorStatus newStatus = MentorStatus.valueOf(statusText.toUpperCase());
//
//          MentorRequest updatedRequest = mir.updateStatus(id, newStatus);
//          return ResponseEntity.ok(updatedRequest);
//
//      } catch (IllegalArgumentException e) {
//          return ResponseEntity.badRequest().body("Invalid mentor status provided.");
//      }
//  }

  
  @PutMapping("/{id}/status")
  public ResponseEntity<MentorRequest> updateRequestStatus(
          @PathVariable Long id,
          @RequestBody StatusUpdateRequest request) {
      
      String statusText = request.getStatus(); // Get status from DTO

      if (statusText == null || statusText.isBlank()) {
          throw new IllegalArgumentException("Status must not be null or empty.");
      }

      MentorStatus newStatus = MentorStatus.valueOf(statusText.toUpperCase());
      MentorRequest updatedRequest = mir.updateStatus(id, newStatus);

      return ResponseEntity.ok(updatedRequest);
  }

  @GetMapping("/all")
  public ResponseEntity<List<MentorRequest>> getAllMentorRequests() {
      return ResponseEntity.ok(mir.getAllMentorRequests());
  }
  
  
  @GetMapping("/{requestId}")
  public ResponseEntity<MentorRequest> getMentorRequestById(@PathVariable Long requestId) {
      MentorRequest mentorRequest = mir.getMentorRequestById(requestId);
      if (mentorRequest != null) {
          return ResponseEntity.ok(mentorRequest);
      }
      return ResponseEntity.notFound().build();
  }
}
