package com.TechCoder.LawSetu.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.TechCoder.LawSetu.helper.CustomResponse;
import com.TechCoder.LawSetu.model.Contact;
import com.TechCoder.LawSetu.service.ContactService;
import com.TechCoder.LawSetu.service.EmailServiceImpl;


@RestController
@RequestMapping(value="/lawsetu")
public class ContactController {

	@Autowired
	private ContactService contactService;
	
	@Autowired
	private EmailServiceImpl emailServiceImpl;
	// Save contact
//	Update Password
	@PostMapping(value="/contact-us")
	public ResponseEntity<CustomResponse> saveContact(@RequestBody Contact contactObj){
		
		Contact contact = contactService.saveContact(contactObj);
		CustomResponse customResponse = new CustomResponse();
		if(contact.getUserId() == null) {
			customResponse.setMessage("ERROR");
		}else {
			customResponse.setMessage("SUCCESS");
			emailServiceImpl.contactUsMail(contactObj);
		}
		customResponse.setHttpStatus(HttpStatus.OK);
		customResponse.setUserEmail(contactObj.getUserEmail());
		
		return ResponseEntity.status(HttpStatus.CREATED).body(customResponse);
		
	}
	
	
	// Find all 
	@GetMapping(value="/find-all-contacts")
	public Iterable<Contact> findAll(){
		return contactService.findAll();
	}
}
