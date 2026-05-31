package com.TechCoder.LawSetu.dao;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.TechCoder.LawSetu.model.User;

@Repository
public interface UserDao extends CrudRepository<User, Long> {

	public Optional<User> findByUserEmail(String userEmail);
	
}
