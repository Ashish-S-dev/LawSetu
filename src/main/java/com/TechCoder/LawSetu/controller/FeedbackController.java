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
import com.TechCoder.LawSetu.model.Feedback;
import com.TechCoder.LawSetu.service.FeedbackService;

@RestController
@RequestMapping(value="/lawsetu")
public class FeedbackController {
	
	@Autowired
	private FeedbackService feedbackService;
	
	// Find all Feedback
	@GetMapping(value="/find-all-feedback")
	public Iterable<Feedback> findAll(){
		return feedbackService.findAll();
	}
	
	// Add new Feedback
	@PostMapping(value="/add-new-feedback")
	public ResponseEntity<CustomResponse> newFeedback(@RequestBody Feedback feedbackObj ) {
		CustomResponse customResponse = new CustomResponse();
		Feedback feedbackOut = feedbackService.newFeedback(feedbackObj);
		if(feedbackOut.getFdbkMessage() != null) {
			customResponse.setMessage("SUCCESS");
		}else {
			customResponse.setMessage("ERROR");
		}
		customResponse.setHttpStatus(HttpStatus.OK);
		customResponse.setUserEmail("demo@gmail.com");
		
		return ResponseEntity.status(HttpStatus.CREATED).body(customResponse);
	}
	
	// Delete All feedback
	public void deleteAll() {
		feedbackService.deleteAll();
	}
	
}
