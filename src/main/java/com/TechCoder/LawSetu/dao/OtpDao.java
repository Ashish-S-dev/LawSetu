package com.TechCoder.LawSetu.dao;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.TechCoder.LawSetu.model.OtpTbl;




@Repository
public interface OtpDao extends CrudRepository<OtpTbl, Integer> {
	
	// No need to manage the database query, it is automatically created by the JPA 
	public Optional<OtpTbl> findByUserEmail(String userEmail);
	
	public void deleteByUserEmail(String userEmail);
	
}