package com.capg.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.capg.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, String> {

	public User findByUserEmailIdAndUserPassword(String userEmailId, String password);

	public Optional<User> getUserByUserEmailId(String userEmailId);

}