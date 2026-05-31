package com.TechCoder.LawSetu.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.TechCoder.LawSetu.model.Advocate;
import com.TechCoder.LawSetu.service.AdvocateService;

@RestController
@RequestMapping(value="/lawsetu")
public class AdvocateController {

	@Autowired
	private AdvocateService advocateService;
	
	@GetMapping(value="/find-all-advocate")
	public Iterable<Advocate> findAllAdvocate(){
		return advocateService.findAllAdvocate();
	}
	@GetMapping(value="/find-by-barcouncil/{number}")
	public Advocate findLawyer(@PathVariable String number) {
		return advocateService.findByBarCouncilId(number);
	}
	
}
