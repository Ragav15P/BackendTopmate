package com.Propeers.Ragav.BackendTopmate.service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import com.Propeers.Ragav.BackendTopmate.entity.User;

public interface UserInterface 
{
	User createUser(User user);
    User getUserById(Long id);
    List<User> getAllUsers();
    User updateUser(Long id, User user);
    void deleteUser(Long id);
    Optional<User> getUserByEmail(String email);
    Boolean existsByUsername(String username);
    List<User> getUsersByProfession(String profession);
    
    List<User> searchByProfessionKeyword(String keyword);
    List<User> searchUsersByFullName(String keyword);
    List<User> getUsersCreatedAfter(LocalDate date);


}
