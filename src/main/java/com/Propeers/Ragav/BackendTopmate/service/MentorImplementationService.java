package com.Propeers.Ragav.BackendTopmate.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Propeers.Ragav.BackendTopmate.entity.MentorRequest;
import com.Propeers.Ragav.BackendTopmate.entity.MentorStatus;
import com.Propeers.Ragav.BackendTopmate.entity.User;
import com.Propeers.Ragav.BackendTopmate.repo.MentorRepository;
import com.Propeers.Ragav.BackendTopmate.repo.UserRepository;

@Service
public class MentorImplementationService implements MentorInterface 
{
	@Autowired
    private MentorRepository mr;
	
	@Autowired
    private UserRepository userRepository;

	@Override
	public MentorRequest createMentorRequest(Long userId) 
	{
		
		Optional<User> userOpt = userRepository.findById(userId);
        if (userOpt.isPresent()) {
            User user = userOpt.get();
            MentorRequest mentorRequest = new MentorRequest();
            mentorRequest.setUser(user);
            mentorRequest.setStatus(MentorStatus.PENDING);
            mentorRequest.setRequestedAt(LocalDateTime.now());
            return mr.save(mentorRequest);
        }
        return null; 
	}

	@Override
	public MentorRequest updateMentorRequestStatus(Long requestId, MentorStatus status) {
		 Optional<MentorRequest> requestOpt = mr.findById(requestId);
	        if (requestOpt.isPresent()) {
	            MentorRequest mentorRequest = requestOpt.get();
	            mentorRequest.setStatus(status);
	            mentorRequest.setProcessedAt(LocalDateTime.now());
	            return mr.save(mentorRequest);
	        }
		return null;
	}

	@Override
	public List<MentorRequest> getAllMentorRequests() {
		// TODO Auto-generated method stub
		return mr.findAll();
	}

	@Override
	public MentorRequest getMentorRequestById(Long requestId) {
		// TODO Auto-generated method stub
		return mr.findById(requestId).orElse(null);
	}

	@Override
	public MentorRequest updateStatus(Long id, MentorStatus newStatus) {
		// TODO Auto-generated method stub
		
		MentorRequest request = mr.findById(id)
		        .orElseThrow(() -> new RuntimeException("MentorRequest not found"));

		    request.setStatus(newStatus);
		    return mr.save(request);
		
	}
	
//	@Override
//	public MentorRequest updateStatus(Long id, MentorStatus newStatus) {
//	    MentorRequest request = mr.findById(id)
//	        .orElseThrow(() -> new RuntimeException("MentorRequest not found"));
//
//	    request.setStatus(newStatus);
//	    return mr.save(request);
//	}

}
