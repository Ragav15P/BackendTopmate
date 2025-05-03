package com.Propeers.Ragav.BackendTopmate.service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import com.Propeers.Ragav.BackendTopmate.entity.Role;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Propeers.Ragav.BackendTopmate.entity.User;
import com.Propeers.Ragav.BackendTopmate.repo.UserRepository;
@Service
public class UserInterfaceImplementation implements UserInterface
{
	@Autowired
	private UserRepository userrepo;

	@Override
	public User createUser(User user) 
	{
		user.setRole(Role.USER);

		return userrepo.save(user);
	}

	@Override
	public User getUserById(Long id) 
	{
		
		return userrepo.findById(id).orElse(null);
	}

	@Override
	public List<User> getAllUsers() 
	{
	
		return userrepo.findAll();
	}

	@Override
	public User updateUser(Long id, User userDetails) 
	{
		
		Optional<User> optionalUser = userrepo.findById(id);
        if (optionalUser.isPresent()) {
            User userold = optionalUser.get();
            userold.setFullName(userDetails.getFullName());
            userold.setUsername(userDetails.getUsername());
            userold.setEmail(userDetails.getEmail());
            userold.setPassword(userDetails.getPassword());
            userold.setBio(userDetails.getBio());
            userold.setProfession(userDetails.getProfession());
            userold.setProfilePicture(userDetails.getProfilePicture());
            userold.setSocialLinks(userDetails.getSocialLinks());
            return userrepo.save(userold);
        }
        return null;
	}

	@Override
	public void deleteUser(Long id) 
	{
		
		userrepo.deleteById(id);
	}

	@Override
	public Optional<User> getUserByEmail(String email) {
	    return userrepo.findByEmail(email);
	}

	@Override
	public Boolean existsByUsername(String username) {
	    return userrepo.existsByUsername(username);
	}
	
	@Override
	public List<User> getUsersByProfession(String profession) {
	    return userrepo.findByProfession(profession);
	}
	@Override
	public List<User> searchByProfessionKeyword(String keyword) {
	    return userrepo.searchByProfessionKeyword(keyword);
	}
	@Override
	public List<User> searchUsersByFullName(String keyword) {
	    return userrepo.searchByFullName(keyword);
	}
	
	@Override
	public List<User> getUsersCreatedAfter(LocalDate date) {
	    return userrepo.findUsersCreatedAfter(date);
	}





}
