package com.TechCoder.LawSetu.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.servlet.http.HttpSession;

@RestController
@RequestMapping("/lawsetu")
public class SessionController {

	@GetMapping("/session-data")
    public Map<String, Object> getSessionData(HttpSession session) {

        Map<String, Object> data = new HashMap<>();
        data.put("userId", session.getAttribute("userId"));
        data.put("userName", session.getAttribute("userName"));
        data.put("userEmail", session.getAttribute("userEmail"));
        data.put("userMobileNo", session.getAttribute("userMobileNo"));
        data.put("userCity", session.getAttribute("userCity"));
        data.put("userRole", session.getAttribute("userRole"));
        data.put("state", session.getAttribute("state"));

        return data;
    }

	
}
