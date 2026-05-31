package com.TechCoder.LawSetu.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.TechCoder.LawSetu.dao.ContactDao;
import com.TechCoder.LawSetu.model.Contact;

@Service
public class ContactService {

	@Autowired
	private ContactDao contactDao;
	
	// New Contact Message 
	public Contact saveContact(Contact contactObj) {
		
		Contact contactSearch = contactDao.findByUserEmail(contactObj.getUserEmail()).orElse(new Contact());	
		
		if(contactSearch.getUserId() == null ) {
			
			return contactDao.save(contactObj);
		}else {
			contactSearch.setUserName(contactObj.getUserName());
			contactSearch.setUserMessage(contactObj.getUserMessage());
			
			return contactDao.save(contactSearch);
		}
		
	}
	
	// Find all contact message 
	
	public Iterable<Contact> findAll() {
		 return contactDao.findAll();
	}
	
	public Contact findbyUserEmail(String userEmail) {
		return contactDao.findByUserEmail(userEmail).orElse(new Contact());
	}
	
}
