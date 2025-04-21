package com.Propeers.Ragav.BackendTopmate.repo;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.Propeers.Ragav.BackendTopmate.entity.User;

public interface UserRepository extends JpaRepository<User,Long>
{
	Optional<User> findByEmail(String email);
	Boolean existsByUsername(String username);
	List<User> findByProfession(String profession);
	@Query("SELECT u FROM User u WHERE LOWER(u.fullName) LIKE LOWER(CONCAT('%', :keyword, '%'))")
	List<User> searchByFullName(@Param("keyword") String keyword);
	List<User> findByCreatedAtAfter(LocalDateTime date);
	
	@Query("SELECT u FROM User u WHERE LOWER(u.profession) LIKE LOWER(CONCAT('%', :keyword, '%'))")
	List<User> searchByProfessionKeyword(@Param("keyword") String keyword);
	@Query("SELECT u FROM User u WHERE u.createdAt > :date")
	List<User> findUsersCreatedAfter(@Param("date") LocalDate date);


}
