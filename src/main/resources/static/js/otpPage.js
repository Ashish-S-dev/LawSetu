// Sign Up Page JavaScript
function showStep(stepName) {
	const steps = document.querySelectorAll('.form-step');
	steps.forEach(step => step.classList.remove('active'));
	document.getElementById('step-' + stepName).classList.add('active');
}

const errorElement = document.querySelector("#error-element");
const sendOtpBtn = document.querySelector("#send-otp-btn");

// API Calling
async function sendOtpAPI(userEmail) {

	try {

		const response = await fetch("/lawsetu/send-otp/" + userEmail);

		// convert response into JSON
		const data = await response.json();
		//console.log(data);
		sendOtpBtn.innerText = "Send Otp";
		if (data.message === "OTP Send Successfully") {
			showStep('otp');
			return true;
		} else if (data.message === "Resend OTP") {
			return true;
		} else if (data.message === "Email not exist") {
			errorElement.style.display = "block";
			setTimeout(() => {
				errorElement.style.display = "none";
			}, 3000);
			return false;
		} else {
			return false;
		}

	} catch (error) {

		console.log("Error : " + error);

	}
}

async function activateAccount(userEmail) {

	try {

		const response = await fetch("/lawsetu/activate-user/" + userEmail);

		// convert response into JSON
		const data = await response.json();

		console.log(data);
		if (data) {
			// Yha user True return kar rha hai
		} else {
			errorElement.innerText = "❌ Server Error";
			errorElement.style.display = "block";
			setTimeout(() => {
				errorElement.style.display = "none";
			}, 3000);
		}

	} catch (error) {

		console.log("Error : " + error);

	}
}

// Find OTP From Database
async function validateOtp(otp, userEmail) {

	try {

		const response = await fetch("/lawsetu/find-otp-user-email/" + userEmail);

		// convert response into JSON
		const data = await response.json();

		
		if (data.otp == otp) {
			activateAccount(userEmail);
			showStep('usertype');
			setTimeout(()=>{
				window.location.href = "/lawsetu/user-login";
			}, 5000);
		} else {
			errorElement.innerText = "❌ Incorrect OTP";
			errorElement.style.display = "block";
			setTimeout(() => {
				errorElement.style.display = "none";
			}, 3000);
		}

	} catch (error) {

		console.log("Error : " + error);

	}
}


document.addEventListener('DOMContentLoaded', function() {

	// Variables
	let currentUserType = '';
	let userEmail = '';

	// Email Form Submission
	const emailForm = document.getElementById('emailForm');
	emailForm.addEventListener('submit', function(e) {
		e.preventDefault();
		const emailInput = document.getElementById('email');
		const emailRegex = /^[^\s@]+@[^\s@]+\.[^\s@]+$/;
		if (emailRegex.test(emailInput.value)) {
			userEmail = emailInput.value;
			sendOtpBtn.innerText = "Please wait..";
			let otpApiCall = sendOtpAPI(userEmail);
			document.getElementById('displayEmail').textContent = userEmail;
		} else {
			alert('Please enter a valid email address');
		}
	});

	// OTP Input Auto-navigation
	const otpInputs = document.querySelectorAll('.otp-input');

	otpInputs.forEach((input, index) => {
		input.addEventListener('input', function(e) {
			// Only allow numbers
			this.value = this.value.replace(/[^0-9]/g, '');

			// Move to next input
			if (this.value.length === 1 && index < otpInputs.length - 1) {
				otpInputs[index + 1].focus();
			}
		});

		input.addEventListener('keydown', function(e) {
			// Handle backspace
			if (e.key === 'Backspace' && this.value === '' && index > 0) {
				otpInputs[index - 1].focus();
			}
		});

		input.addEventListener('paste', function(e) {
			e.preventDefault();
			const pasteData = e.clipboardData.getData('text');
			const numbers = pasteData.replace(/[^0-9]/g, '').split('');

			numbers.forEach((num, i) => {
				if (i < otpInputs.length) {
					otpInputs[i].value = num;
				}
			});

			// Focus last filled input
			if (numbers.length > 0 && numbers.length <= otpInputs.length) {
				otpInputs[Math.min(numbers.length, otpInputs.length - 1)].focus();
			}
		});
	});

	// OTP Form Submission
	const otpForm = document.getElementById('otpForm');
	otpForm.addEventListener('submit', function(e) {
		e.preventDefault();

		// Get OTP value
		let otp = '';
		otpInputs.forEach(input => {
			otp += input.value;
		});

		if (otp.length === 6) {


			validateOtp(otp, userEmail);


		} else {
			alert('Please enter the complete 6-digit OTP');
		}
	});
});


window.onload = function () {

    const savedTheme = localStorage.getItem("theme") || "light";

    document.body.classList.add(savedTheme);
}




