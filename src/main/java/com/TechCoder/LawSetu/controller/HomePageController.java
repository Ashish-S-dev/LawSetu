package com.TechCoder.LawSetu.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import jakarta.servlet.http.HttpSession;


@Controller
public class HomePageController {

	@GetMapping("/")
	public String showLandingPage2(HttpSession session) {
		session.invalidate();
		return "landingPage";
	}
	
}
