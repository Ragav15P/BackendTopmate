package com.Propeers.Ragav.BackendTopmate.service;

import java.util.List;

import com.Propeers.Ragav.BackendTopmate.entity.MentorRequest;
import com.Propeers.Ragav.BackendTopmate.entity.MentorStatus;

public interface MentorInterface 
{
	MentorRequest createMentorRequest(Long userId);
    MentorRequest updateMentorRequestStatus(Long requestId, MentorStatus status);
    List<MentorRequest> getAllMentorRequests();
    MentorRequest getMentorRequestById(Long requestId);
    
    MentorRequest updateStatus(Long id, MentorStatus newStatus);

}
