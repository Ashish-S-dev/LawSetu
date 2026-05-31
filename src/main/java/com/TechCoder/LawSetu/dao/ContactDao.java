package com.TechCoder.LawSetu.dao;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.TechCoder.LawSetu.model.Contact;

@Repository
public interface ContactDao extends CrudRepository<Contact, Integer> {

	public Optional<Contact> findByUserEmail(String userEmail);
	
}
