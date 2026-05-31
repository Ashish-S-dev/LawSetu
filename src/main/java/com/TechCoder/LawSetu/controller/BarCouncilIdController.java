package com.TechCoder.LawSetu.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.TechCoder.LawSetu.model.BarCouncilId;
import com.TechCoder.LawSetu.service.BarCouncilIdService;

@RestController
@RequestMapping(value="/lawsetu")
public class BarCouncilIdController {

	@Autowired
	private BarCouncilIdService barCouncilidService;
	
	@GetMapping(value="/find-all-councilid")
	public Iterable<BarCouncilId> findAll(){
		return barCouncilidService.findAll();
	}
	
	@GetMapping(value="/find-council-userEmail/{userEmail}")
	public BarCouncilId findByUserName(@PathVariable String userEmail) {
		return barCouncilidService.findByUserEmail(userEmail);
	}
	
	@PostMapping(value="/add-council")
	public BarCouncilId addLawyer(@RequestBody BarCouncilId councilObj) {
		return barCouncilidService.addLawyer(councilObj);
	}
}
