package com.TechCoder.LawSetu.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping(value = "/lawsetu")
public class PageController {

	// Landing page of the website
	@GetMapping
	public String showLandingPage(HttpSession session) {
		session.invalidate();
		return "landingPage";
	}

	@GetMapping("/user-login")
	public String showLoginPage() {
		return "login";
	}

	@GetMapping("/user-signup")
	public String showSignupPage(HttpSession session) {
		session.invalidate();
		return "signup";
	}

	@GetMapping("/client-dashboard")
	public String showClientDashboard(HttpSession session) {

		Integer userRole = (Integer) session.getAttribute("userRole");

		if (session.getAttribute("userId") != null && userRole == 2) {

			return "cdashboard";

		}
		return "redirect:/lawsetu";
	}

	@GetMapping("/client-casedetails")
	public String showClientCase(HttpSession session) {

		Integer userRole = (Integer) session.getAttribute("userRole");

		if (session.getAttribute("userId") != null && userRole == 2) {

			return "usercasedetails";

		}
		return "redirect:/lawsetu";
	}

	@GetMapping("/user-update-profile")
	public String showUserUpdate(HttpSession session) {

		Integer userRole = (Integer) session.getAttribute("userRole");

		if (session.getAttribute("userId") != null && userRole == 2) {

			return "updateprofile";

		}
		return "redirect:/lawsetu";
	}

	@GetMapping("/civil-lawyer")
	public String showCivilLayer(HttpSession session) {

		Integer userRole = (Integer) session.getAttribute("userRole");

		if (session.getAttribute("userId") != null && userRole == 2) {

			return "civilCase";

		}
		return "redirect:/lawsetu";
	}

	// user Dashboard
	@GetMapping("/user-profile")
	public String showUserProfile(HttpSession session) {

		Integer userRole = (Integer) session.getAttribute("userRole");

		if (session.getAttribute("userId") != null && userRole == 2) {

			return "UserProfile";

		}
		return "redirect:/lawsetu";
	}
	
	// Video Call
	@GetMapping("/video-call")
	public String showVideo(HttpSession session) {

		Integer userRole = (Integer) session.getAttribute("userRole");

		if (session.getAttribute("userId") != null ) {

			return "videoCall";

		}
		return "redirect:/lawsetu";
	
	}

	// Lawyer Section Mapping

	@GetMapping("/lawyer-dashboard")
	public String showLawyerDashboard(HttpSession session) {

		Integer userRole = (Integer) session.getAttribute("userRole");

		if (session.getAttribute("userId") != null && userRole == 1) {

			return "lDashboard";

		}
		return "redirect:/lawsetu";
	}

	@GetMapping("/lawyer-case-study")
	public String showLayerCaseStudy(HttpSession session) {

		Integer userRole = (Integer) session.getAttribute("userRole");

		if (session.getAttribute("userId") != null && userRole == 1) {

			return "lCaseStudy";

		}
		return "redirect:/lawsetu";
	}

	@GetMapping("/lawyer-client-request")
	public String showLawyerClientRequest(HttpSession session) {

		Integer userRole = (Integer) session.getAttribute("userRole");

		if (session.getAttribute("userId") != null && userRole == 1) {

			return "lClientRequest";

		}
		return "redirect:/lawsetu";
	}

	@GetMapping("/lawyer-earning")
	public String showLawyerEarning(HttpSession session) {

		Integer userRole = (Integer) session.getAttribute("userRole");

		if (session.getAttribute("userId") != null && userRole == 1) {

			return "lawyerEarning";

		}
		return "redirect:/lawsetu";
	}

	// Otp page
	@GetMapping("/otp-page")
	public String showOtpPage(HttpSession session) {

		session.invalidate();
		return "otpPage";

	}



	// Lawyer Dashboard
	@GetMapping("/lawyer-profile")
	public String showLawyerProfile(HttpSession session) {

		Integer userRole = (Integer) session.getAttribute("userRole");

		if (session.getAttribute("userId") != null && userRole == 1) {

			return "LawyerProfile";

		}
		return "redirect:/lawsetu";
	}

	
	
	@GetMapping("/about-lawsetu")
	public String aboutUs(HttpSession session) {
		
		return "aboutUs";
	}
	
	
}
