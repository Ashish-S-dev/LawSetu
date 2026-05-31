const msg = document.querySelector("#msg");;
const feedbackContainer = document.getElementById("feedback");


function scrollLeftCard() {
	document.getElementById("feedback").scrollLeft -= 350;
}

function scrollRightCard() {
	document.getElementById("feedback").scrollLeft += 350;
}

/* COUNTER */
let counters = document.querySelectorAll('.count');

counters.forEach(counter => {
	let target = +counter.getAttribute('data-target');
	let count = 0;
	let inc = target / 100;

	let update = () => {
		count += inc;

		if (count < target) {
			counter.innerText = Math.floor(count);
			requestAnimationFrame(update);
		} else {
			counter.innerText = target;
		}
	}
	update();
});

// Selecting the Menu field for counter
const resolvedCase = document.querySelector(".resolved-counter");
const clientSatisfaction = document.querySelector(".client-satisfaction");
const clientExp = document.querySelector(".exp");

// Menu Resolved Counter
let start = 0;
let end = 500;
let menuCounter = setInterval(() => {
	start++;
	resolvedCase.innerText = start + "+";
	if (start === end) {
		clearInterval(menuCounter)
	}
}, 15);

// Satisfied Counter
let startS = 0;
let endS = 95;
let satisfiedCounter = setInterval(() => {
	startS++;
	clientSatisfaction.innerText = startS + "%";
	if (startS === endS) {
		clearInterval(satisfiedCounter)
	}
}, 80);

// Satisfied Counter
let startE = 0;
let endE = 10;
let expCounter = setInterval(() => {
	startE++;
	clientExp.innerText = startE + "+";
	if (startE === endE) {
		clearInterval(expCounter)
	}
}, 600);

//feedback
function addFeedback() {

	let name = document.getElementById("username").value;
	let msg = document.getElementById("message").value;

	if (name === "" || msg === "") {
		//alert("Please fill all fields");
		emptyFieldMsg();
		return;
	}

	// Save the feedback into the Database
	addFdbkDb(name, msg);

	let card = document.createElement("div");
	card.classList.add("feedback-card");

	if (msg.length >= 25) {
		card.innerHTML = `
		        	<h3>${name}</h3>
		        	<p>⭐⭐⭐⭐⭐</p>
		        	<p>${msg}</p>
		    	`;
	} else {
		card.innerHTML = `
		        	<h3>${name}</h3>
		        	<p>⭐⭐⭐⭐</p>
		        	<p>${msg}</p>
		    	`;
	}


	feedbackContainer.prepend(card);

	// clear input
	document.getElementById("username").value = "";
	document.getElementById("message").value = "";
}


// Add feedback into the database

async function addFdbkDb(name, msg) {
	let fdbkData = {
		"fdbkUserName": name,
		"fdbkMessage": msg
	};

	try {
		let api = "/lawsetu/add-new-feedback";
		const res = await fetch(api, {
			method: "POST",
			headers: {
				"Content-Type": "application/json"
			},
			body: JSON.stringify(fdbkData)
		});

		const data = await res.json();
		console.log(data);
		if (data.message === "ERROR") {
			serverFailure();
		} else {
			successMessage();
		}
		// Successfully register section ka response mil gya

	} catch (e) {

	}
}
// Email Validation
function isValidEmail(email) {
	const pattern = /^[^\s@]+@[^\s@]+\.[^\s@]+$/;
	return pattern.test(email);
}


// Contact Section Call

async function sendContactMessage() {

	const name = document.getElementById("contact-username").value.trim();
	const email = document.getElementById("contact-useremail").value.trim();
	const message = document.getElementById("contact-message").value.trim();

	// ✅ Validation

	if (!name || !email || !message) {
		emptyFieldMsg();
		return;
	}

	if (!isValidEmail(email)) {
		invalidEmail();
		return;
	}

	const payload = {
		"userName": name,
		"userEmail": email,
		"userMessage": message
	};

	// Clear Input Field
	document.getElementById("contact-username").value = "";
	document.getElementById("contact-useremail").value = "";
	document.getElementById("contact-message").value = "";

	try {
		const response = await fetch("/lawsetu/contact-us", {
			method: "POST",
			headers: {
				"Content-Type": "application/json"
			},
			body: JSON.stringify(payload)
		});

		const result = await response.json();

		// ✅ Success handling (based on your backend response)
		if (result.message === "SUCCESS") {
			successMessage2();
		} else {
			serverFailure2();
		}

	} catch (error) {
		//console.error(error);
		serverFailure();
	}


}

function serverFailure2() {

	msg.innerText = "❌ Please try again or refresh your browser.";
	msg.classList.add("error");
	msg.style.display = "block";

	setTimeout(() => {
		msg.style.display = "none";
		msg.innerText = "";
		msg.classList.remove("error");
	}, 10000); // 10 seconds
}

function successMessage2() {

	msg.innerText = "✅ Thank you for contacting us. We have received your details and will get in touch with you shortly.";
	msg.classList.add("success");
	msg.style.display = "block";

	setTimeout(() => {
		msg.style.display = "none";
		msg.innerText = "";
		msg.classList.remove("success");
	}, 10000); // 10 seconds
}

function invalidEmail() {
	msg.innerText = "❌ Please enter valid email";
	msg.classList.add("error");
	msg.style.display = "block";

	setTimeout(() => {
		msg.style.display = "none";
		msg.innerText = "";
		msg.classList.remove("error");
	}, 10000); // 10 seconds
}


function successMessage() {

	msg.innerText = "🔥 Thank you for your feedback. We’re glad you’re satisfied with our service.";
	msg.classList.add("success");
	msg.style.display = "block";

	setTimeout(() => {
		msg.style.display = "none";
		msg.innerText = "";
		msg.classList.remove("success");
	}, 10000); // 10 seconds
}

function emptyFieldMsg() {

	msg.innerText = "❌ Please ensure that all required fields are filled before submitting the form.";
	msg.classList.add("error");
	msg.style.display = "block";

	setTimeout(() => {
		msg.style.display = "none";
		msg.innerText = "";
		msg.classList.remove("error");
	}, 10000); // 10 seconds
}

function serverFailure() {

	msg.innerText = "❌ A technical error occurred. Please try again or refresh your browser.";
	msg.classList.add("error");
	msg.style.display = "block";

	setTimeout(() => {
		msg.style.display = "none";
		msg.innerText = "";
		msg.classList.remove("error");
	}, 10000); // 10 seconds
}

// Onload Functions

function renderUsers(users) {

	users.forEach(user => {
		let name = user.fdbkUserName;
		let msg = user.fdbkMessage;
		let card = document.createElement("div");
		card.classList.add("feedback-card");
		if (msg.length >= 25) {
			card.innerHTML = `
				        	<h3>${name}</h3>
				        	<p>⭐⭐⭐⭐⭐</p>
				        	<p>${msg}</p>
				    	`;
		} else {
			card.innerHTML = `
				        	<h3>${name}</h3>
				        	<p>⭐⭐⭐⭐</p>
				        	<p>${msg}</p>
				    	`;
		}
		feedbackContainer.prepend(card);

	});
}



async function loadFeedback() {
	try {
		const response = await fetch("/lawsetu/find-all-feedback"); // apna endpoint
		const result = await response.json();
		if (Array.isArray(result)) {
			let newData = result;
			//console.log(newData);
			renderUsers(newData);
		}
	} catch (error) {
		//console.error(error);
		serverFailure();
	}
}

window.onload = loadFeedback;



// Onload Function End

window.onload = function () {

    const savedTheme = localStorage.getItem("theme") || "light";

    document.body.classList.add(savedTheme);
}


function toggleMode() {

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

// Ham Btn JS

function hamMenuToggle(){
	const hamMenu = document.querySelector(".ham-menu");
	hamMenu.classList.toggle("show-ham-menu");
}
