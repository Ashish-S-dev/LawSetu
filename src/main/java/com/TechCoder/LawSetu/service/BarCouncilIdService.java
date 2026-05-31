package com.TechCoder.LawSetu.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.TechCoder.LawSetu.dao.BarCouncilIdDao;
import com.TechCoder.LawSetu.model.BarCouncilId;

@Service
public class BarCouncilIdService {

	@Autowired
	private BarCouncilIdDao barCouncilId ;
	
	// Find all
	public Iterable<BarCouncilId> findAll(){
		return barCouncilId.findAll();
	}
	
	// Find By user Email
	public BarCouncilId findByUserEmail(String userEmail) {
		return barCouncilId.findByLawyerEmail(userEmail).orElse(new BarCouncilId());
	}
	
	
	// add lawyer
	public BarCouncilId addLawyer(BarCouncilId barCouncilIdObj) {
		
		return barCouncilId.save(barCouncilIdObj);
		
	}
	
}
