//package com.TechCoder.LawSetu.controller;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//import com.TechCoder.LawSetu.model.Roles;
//import com.TechCoder.LawSetu.service.RoleService;
//
//
//
//@RestController
//@RequestMapping(value="/role")
//public class RoleController {
//	
////	@RequestMapping(value="/index")
////	public String example() {
////		return "index";
////	}
//	@Autowired
//	private RoleService roleService;
//	@PostMapping(value="/create")
//	public Roles save(@RequestBody Roles roleObj) {
//		return roleService.createRole(roleObj);
//	}
//	
//}