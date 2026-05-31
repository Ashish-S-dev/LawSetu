package com.TechCoder.LawSetu.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.TechCoder.LawSetu.helper.AdvocateLogin;
import com.TechCoder.LawSetu.helper.CustomResponse;
import com.TechCoder.LawSetu.helper.LoginData;
import com.TechCoder.LawSetu.model.Advocate;
import com.TechCoder.LawSetu.model.BarCouncilId;
import com.TechCoder.LawSetu.model.User;
import com.TechCoder.LawSetu.service.AdvocateService;
import com.TechCoder.LawSetu.service.BarCouncilIdService;
import com.TechCoder.LawSetu.service.EmailService;
import com.TechCoder.LawSetu.service.UserService;

import jakarta.servlet.http.HttpSession;

@RestController
@RequestMapping(value = "/lawsetu")
public class UserController {

	@Autowired
	private UserService userService;
	
	@Autowired
	private AdvocateService advocateService;
	
	@Autowired
	private BarCouncilIdService barCouncilIdService;
	
	@Autowired
	private EmailService emailService;
	
	
	
	
//	User Login
	@PostMapping(value="/client/login")
	public ResponseEntity<CustomResponse> loginUser(@RequestBody LoginData loginData, HttpSession session){
		
		Boolean state = userService.loginUser(loginData.getUserEmail(), loginData.getUserPassword());
		//System.out.println("Hello"+loginData.getUserEmail()+"   "+loginData.getUserPassword()+"  Ashishs ");
		CustomResponse customResponse = new CustomResponse();
			
		
		if(state) {
			
			User userObj = userService.findByUserEmail(loginData.getUserEmail());
			if(userObj.isActive()) {
				createSession(userObj, session);
				customResponse.setMessage("Valid user");
				
			}else {
				
				customResponse.setMessage("Account deactivated");
				
			}
			
		}else {
			customResponse.setMessage("User not found");
		}
		customResponse.setHttpStatus(HttpStatus.OK);
		customResponse.setUserEmail(loginData.getUserEmail());
		
		return ResponseEntity.status(HttpStatus.CREATED).body(customResponse);

		
	}
	
	
// Register the user
	@PostMapping(value = "/client/register")
	public ResponseEntity<CustomResponse> registerUser(@RequestBody User userObj) {

		CustomResponse customResponse = new CustomResponse();

		// User Register in Database

		User checkResult = userService.findByUserEmail(userObj.getUserEmail());

		if (checkResult.getUserId() == null) {

			userService.registerUser(userObj);
			// Confirm email Send
			emailService.accountCreated(userObj.getUserEmail());

			customResponse.setMessage("User registered successfully");
		} else {
			customResponse.setMessage("Email already exist");
		}
		customResponse.setHttpStatus(HttpStatus.OK);
		customResponse.setUserEmail(userObj.getUserEmail());
		return ResponseEntity.status(HttpStatus.CREATED).body(customResponse);
	}

//	User Login
	@PostMapping(value="/lawyer/login/{barCouncilId}")
	public ResponseEntity<CustomResponse> loginLawyer(@PathVariable String barCouncilId, @RequestBody AdvocateLogin loginData, HttpSession session){
		
		Boolean state = userService.loginAdvocate(loginData.getUserEmail(), loginData.getUserPassword());
		//System.out.println("Hello  "+loginData.getUserEmail()+"   "+loginData.getUserPassword()+"  State of result "+state);
		CustomResponse customResponse = new CustomResponse();
			
		//System.out.println("Hello Ashish "+loginData.getUserEmail() + "  "+ loginData.getUserPassword() +"  "+ loginData.getBarCouncilid());
		
		if(state) {
			
			User userObj = userService.findByUserEmail(loginData.getUserEmail());
			if(userObj.isActive()) {
				
				BarCouncilId bciObject = barCouncilIdService.findByUserEmail(loginData.getUserEmail());
				
				if(barCouncilId.equals(bciObject.getBarCouncilId())) {
					
					createSession(userObj, session);
					customResponse.setMessage("Valid user");
					
				}else {
					customResponse.setMessage("INVALID_BAR_COUNCIL");
				}
				
			}else {
				
				customResponse.setMessage("Account_Deactivated");
				
			}
			
		}else {
			customResponse.setMessage("Invalid_User_Password");
		}
		customResponse.setHttpStatus(HttpStatus.OK);
		customResponse.setUserEmail(loginData.getUserEmail());
		
		return ResponseEntity.status(HttpStatus.CREATED).body(customResponse);

		
	}
	
	
	// Register the user
	@PostMapping(value = "/lawyer/register/{barCouncilId}")
	public ResponseEntity<CustomResponse> registerLawyer(@PathVariable("barCouncilId") String barCouncilId, @RequestBody User userObj) {

		CustomResponse customResponse = new CustomResponse();

		// User Register in Database

		User checkResult = userService.findByUserEmail(userObj.getUserEmail());

		if (checkResult.getUserId() == null) {

			userService.registerUser(userObj);
			// Call database for BarCouncil update
			BarCouncilId bci = new BarCouncilId();
			bci.setBarCouncilId(barCouncilId);
			bci.setLawyerEmail(userObj.getUserEmail());
			barCouncilIdService.addLawyer(bci);
			System.out.println(barCouncilId);
			
			Advocate advocateObj = new Advocate();
			advocateObj.setUserEmail(userObj.getUserEmail());
			advocateObj.setBarCouncilNumber(barCouncilId);
			
			advocateService.setAdvocateBarcouncil(advocateObj);
			
			// Confirm email Send
			emailService.accountCreated(userObj.getUserEmail());

			customResponse.setMessage("User registered successfully");
		} else {
			customResponse.setMessage("Email already exist");
		}
		customResponse.setHttpStatus(HttpStatus.OK);
		customResponse.setUserEmail(userObj.getUserEmail());
		return ResponseEntity.status(HttpStatus.CREATED).body(customResponse);
	}
	
	@GetMapping(value = "/find-all-user")
	public Iterable<User> FindAll() {
		return userService.findAll();
	}

	
	// Activate User
	@GetMapping(value = "/activate-user/{userEmail}")
	public Boolean activateUser(@PathVariable String userEmail) {
		emailService.accountActivated(userEmail);
		return userService.activateAccount(userEmail);
	}
	
	public static void createSession(User userObj, HttpSession session) {
		session.setAttribute("userId", userObj.getUserId());
        session.setAttribute("userName", userObj.getUserName());
        session.setAttribute("userEmail", userObj.getUserEmail());
        session.setAttribute("userMobileNo", userObj.getUserMobileNo());
        session.setAttribute("userCity", userObj.getUserCity());
        session.setAttribute("userRole", userObj.getUserRole());
        session.setAttribute("state", true);
	}
}
