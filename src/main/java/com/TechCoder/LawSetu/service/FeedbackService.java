package com.TechCoder.LawSetu.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.TechCoder.LawSetu.dao.FeedbackDao;
import com.TechCoder.LawSetu.model.Feedback;

@Service
public class FeedbackService {

	@Autowired
	private FeedbackDao feedbackDao;
	
	// Find all
	public Iterable<Feedback> findAll(){
		return feedbackDao.findAll();
	}
	
	// add new feedback
	public Feedback newFeedback(Feedback feedbackObj) {
		return feedbackDao.save(feedbackObj);
	}
	
	// Delete Feedback
	public void deleteAll() {
		feedbackDao.deleteAll();
	}
	
}
