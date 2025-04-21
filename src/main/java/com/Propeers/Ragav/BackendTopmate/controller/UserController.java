package com.Propeers.Ragav.BackendTopmate.controller;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Propeers.Ragav.BackendTopmate.entity.User;
import com.Propeers.Ragav.BackendTopmate.service.UserInterface;

@RestController
	@RequestMapping("/api/users")
	public class UserController {

	    @Autowired
	    private UserInterface userService;

	    @PostMapping("/create")
	    public User createUser(@RequestBody User user) {
	        return userService.createUser(user);
	    }

	    @GetMapping("/{id}")
	    public User getUserById(@PathVariable Long id) {
	        return userService.getUserById(id);
	    }

	    @GetMapping("/getAll")
	    public List<User> getAllUsers() {
	        return userService.getAllUsers();
	    }

	    @PutMapping("/{id}")
	    public User updateUser(@PathVariable Long id, @RequestBody User user) {
	        return userService.updateUser(id, user);
	    }

	    @DeleteMapping("/{id}")
	    public void deleteUser(@PathVariable Long id) {
	        userService.deleteUser(id);
	    }
	    
	    
	    @GetMapping("/email/{email}")
	    public ResponseEntity<User> getUserByEmail(@PathVariable String email) {
	        Optional<User> user = userService.getUserByEmail(email);
	        return user.map(ResponseEntity::ok)
	                   .orElseGet(() -> ResponseEntity.notFound().build());
	    }
	    
	    @GetMapping("/exists/username/{username}")
	    public ResponseEntity<Boolean> checkUsernameExists(@PathVariable String username) {
	        boolean exists = userService.existsByUsername(username);
	        return ResponseEntity.ok(exists);
	    }
	    @GetMapping("/profession/{profession}")
	    public ResponseEntity<List<User>> getUsersByProfession(@PathVariable String profession) {
	        List<User> users = userService.getUsersByProfession(profession);
	        return ResponseEntity.ok(users);
	    }
	    @GetMapping("/profession/search/{keyword}")
	    public ResponseEntity<List<User>> searchUsersByProfession(@PathVariable String keyword) {
	        List<User> users = userService.searchByProfessionKeyword(keyword);
	        return ResponseEntity.ok(users);
	    }
	    @GetMapping("/search/name/{keyword}")
	    public ResponseEntity<List<User>> searchUsersByFullName(@PathVariable String keyword) {
	        List<User> users = userService.searchUsersByFullName(keyword);
	        return ResponseEntity.ok(users);
	    }
	    @GetMapping("/created-after/{date}")
	    public ResponseEntity<List<User>> getUsersCreatedAfter(@PathVariable @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate date) {
	        List<User> users = userService.getUsersCreatedAfter(date);
	        return ResponseEntity.ok(users);
	    }



}
