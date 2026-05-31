package com.TechCoder.LawSetu.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.TechCoder.LawSetu.dao.AdvocateDao;
import com.TechCoder.LawSetu.model.Advocate;

@Service
public class AdvocateService {
	
	@Autowired
	private AdvocateDao advocateDao;
	
	public Advocate findByBarCouncilId(String barCouncilId) {
		return advocateDao.findByBarCouncilNumber(barCouncilId).orElse(new Advocate());
	}
	
	public Boolean setAdvocateBarcouncil(Advocate advocateData) {
		
		Advocate advocate = advocateDao.findByBarCouncilNumber(advocateData.getBarCouncilNumber()).orElse(new Advocate());
		
		if(advocate.getAdvocateId() == null) {
			advocateDao.save(advocateData);
			return true;
		}else {
			return false;
		}
		
	}
	public Iterable<Advocate> findAllAdvocate(){
		return advocateDao.findAll();
	}
	
	
}
