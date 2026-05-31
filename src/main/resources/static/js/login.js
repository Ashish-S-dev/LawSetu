// Tab switching functionality
document.addEventListener('DOMContentLoaded', function() {
	const tabButtons = document.querySelectorAll('.tab-btn');
	const loginForms = document.querySelectorAll('.login-form');

	tabButtons.forEach(button => {
		button.addEventListener('click', function() {
			// Remove active class from all buttons and forms
			tabButtons.forEach(btn => btn.classList.remove('active'));
			loginForms.forEach(form => form.classList.remove('active'));

			// Add active class to clicked button
			this.classList.add('active');

			// Show corresponding form
			const tabName = this.getAttribute('data-tab');
			document.getElementById(tabName + 'LoginForm').classList.add('active');
		});
	});
});




const clientEmail = document.querySelector("#clientEmail");
const clientPassword = document.querySelector("#clientPassword");
const loginBtn = document.querySelector(".client-login");

const lawyerEmail = document.querySelector("#lawyerEmail");
const lawyerPassword = document.querySelector("#lawyerPassword");
const lawyerBarCouncilId = document.querySelector("#barCouncilId");
const submitLawyerBtn = document.querySelector(".submitLawyer");

// Password Validation
function validateEmail(email) {
	const pattern = /^[^ ]+@[^ ]+\.[a-z]{2,3}$/;
	return pattern.test(email);
}
function validatePassword(password) {
	const pattern = /^[A-Za-z]+@[0-9]+$/;
	return pattern.test(password);
}


// User Login 

function clientLogin(e) {
	e.preventDefault();
	let userEmail = clientEmail.value;
	let userPass = clientPassword.value;

	if (!validateEmail(userEmail)) {
		invalidEmail();
		return;
	}

	//console.log(userEmail + "   " + userPass);
	let state = validateEmail(userEmail);
	if (state) {

		// Changing the Button color and text
		loginBtn.style.backgroundColor = "var(--card)";
		loginBtn.style.color = "var(--primary)";
		loginBtn.innerText = "Please wait..";

		// User Login
		login(userEmail, userPass);

	}
	clientEmail.value = "";
	clientPassword.value = "";

}

// user Login API Call
async function login(userEmail, userPass) {

	let userData = {
		"userEmail": userEmail,
		"userPassword": userPass
	};

	try {
		let api = "/lawsetu/client/login";
		const res = await fetch(api, {
			method: "POST",
			headers: {
				"Content-Type": "application/json"
			},
			body: JSON.stringify(userData)
		});

		const data = await res.json();

		//console.log(data); // Successfully register section ka response mil gya

		//Change Button color
		loginBtn.style.backgroundColor = "var(--accent)";
		loginBtn.style.color = "var(--text)";
		loginBtn.innerText = "Login as Client";

		if (data.message === "Valid user") {
			// success
			//console.log("Valid user");
			successMessage();
			setTimeout(() => {
				window.location.href = "/lawsetu/client-dashboard";
			}, 2000);


		} else if (data.message === "User not found") {
			// Registration Failed
			invalidEmail();
			return;

		} else if (data.message === "Account deactivated") {

			deactivateMessage();
			//console.log("Deactivate account");
			setTimeout(() => {
				window.location.href = "/lawsetu/otp-page";
			}, 3000);

		} else {

			failedMessage();
			return;

		}


	} catch (e) {
		// Registration Failed
		failedMessage();
		return;
	}

};

// Lawyer Login API Call
async function lawyerLoginApi(userEmail, userPass, userBarCouncilId) {

	let userData = {
		"userEmail": userEmail,
		"userPassword": userPass
	};

	try {
		let api = `/lawsetu/lawyer/login/${userBarCouncilId}`;
		const res = await fetch(api, {
			method: "POST",
			headers: {
				"Content-Type": "application/json"
			},
			body: JSON.stringify(userData)
		});

		const data = await res.json();

		//console.log(data); // Successfully register section ka response mil gya

		//Change Button color
		submitLawyerBtn.style.backgroundColor = "var(--accent)";
		submitLawyerBtn.style.color = "var(--text)";
		submitLawyerBtn.innerText = "Login as Lawyer";

		if (data.message === "Valid user") {
			// success
			//console.log("Valid user");
			successMessage();
			setTimeout(() => {
				window.location.href = "/lawsetu/lawyer-dashboard";
			}, 2000); // 10 seconds


		} else if (data.message === "INVALID_BAR_COUNCIL") {
			// Registration Failed
			invalidCredintial();
			//console.log("Invalid Bar Council id");
			return;

		} else if (data.message === "Account_Deactivated") {

			//deactivateMessage();
			//console.log("Deactivate account");
			deactivateMessage();
			setTimeout(() => {
				window.location.href = "/lawsetu/otp-page";
			}, 3000);

			return;
			//window.location.href = "/secure-auth/user-account-activate";

		} else if (data.message === "Invalid_User_Password") {
			// Invalid UserName or Password
			invalidEmail();

		} else {
			//console.log("Error in syntax");
			failedMessage();
			return;

		}


	} catch (e) {
		// Registration Failed
		failedMessage();
		return;
	}

};


// Lawyer Login

function lawyerLogin() {


	let lawyerLoginEmail = lawyerEmail.value;
	let lawyerLoginPass = lawyerPassword.value;
	let lawyerLoginId = lawyerBarCouncilId.value;

	if (lawyerLoginEmail === '' || lawyerLoginPass === '' || lawyerLoginId === '') {
		nullFields();
		return;
	}

	if (!validateEmail(lawyerLoginEmail)) {
		invalidEmail();
		return;
	}

	//console.log(lawyerLoginEmail + "   " + lawyerLoginPass+"  "+lawyerLoginId);

	let state = validateEmail(lawyerLoginEmail);
	if (state) {

		// Changing the Button color and text
		submitLawyerBtn.style.backgroundColor = "var(--card)";
		submitLawyerBtn.style.color = "var(--primary)";
		submitLawyerBtn.innerText = "Please wait..";

		// User Login
		lawyerLoginApi(lawyerLoginEmail, lawyerLoginPass, lawyerLoginId);

	}
	lawyerEmail.value = "";
	lawyerPassword.value = "";
	lawyerBarCouncilId.value = "";
}

// Message Section
function successMessage() {

	msg.innerText = "🔥 Login Successfull";
	msg.classList.add("success");
	msg.style.display = "block";

	setTimeout(() => {
		msg.style.display = "none";
		msg.innerText = "";
		msg.classList.remove("success");
	}, 10000); // 10 seconds

};
function invalidEmail() {

	msg.innerText = "❌ Please enter a valid email & Password.";
	msg.classList.add("error");
	msg.style.display = "block";

	setTimeout(() => {
		msg.style.display = "none";
		msg.innerText = "";
		msg.classList.remove("error");
	}, 5000); // 10 seconds

};
function invalidCredintial() {

	msg.innerText = "❌ Invalid BarCouncilId, Please Enter Valid BarCOuncilId.";
	msg.classList.add("error");
	msg.style.display = "block";

	setTimeout(() => {
		msg.style.display = "none";
		msg.innerText = "";
		msg.classList.remove("error");
	}, 5000); // 10 seconds

};
function failedMessage() {

	msg.innerText = "❌ A server error occurred. Please try again or refresh the page..";
	msg.classList.add("error");
	msg.style.display = "block";

	setTimeout(() => {
		msg.style.display = "none";
		msg.innerText = "";
		msg.classList.remove("error");
	}, 10000); // 10 seconds

};

function deactivateMessage() {

	msg.innerText = "❌ Your account is currently inactive. Kindly verify your email address via OTP to activate your account.";
	msg.classList.add("error");
	msg.style.display = "block";

	setTimeout(() => {
		msg.style.display = "none";
		msg.innerText = "";
		msg.classList.remove("error");
	}, 10000); // 10 seconds

};
function nullFields() {

	msg.innerText = "❌ Fill all the Fields";
	msg.classList.add("error");
	msg.style.display = "block";

	setTimeout(() => {
		msg.style.display = "none";
		msg.innerText = "";
		msg.classList.remove("error");
	}, 10000); // 10 seconds

};






window.onload = function () {

    const savedTheme = localStorage.getItem("theme") || "light";

    document.body.classList.add(savedTheme);
}


function toggleTheme() {
	
    const body = document.body;

    body.classList.toggle("dark");
    body.classList.toggle("light");

    
    // SAVE THEME

    if(body.classList.contains("dark")) {

        localStorage.setItem("theme", "dark");

    } else {

        localStorage.setItem("theme", "light");
    }
}

