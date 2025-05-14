package com.Propeers.Ragav.BackendTopmate.service;

import java.util.List;

import com.Propeers.Ragav.BackendTopmate.entity.MentorRequest;
import com.Propeers.Ragav.BackendTopmate.entity.ApprovalStatus;

public interface MentorInterface 
{
	MentorRequest createMentorRequest(Long userId);
    MentorRequest updateMentorRequestStatus(Long requestId, ApprovalStatus status);
    List<MentorRequest> getAllMentorRequests();
    MentorRequest getMentorRequestById(Long requestId);
    
    MentorRequest updateStatus(Long id, ApprovalStatus newStatus);

}
