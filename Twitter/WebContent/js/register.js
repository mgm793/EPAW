var REGISTER = {
	init: function(){
		calendar();
		checkers();
	},
	validate: {
		pass: false,
		user: false,
		mail: false
	}
}


function checkers(){
	checkPassword();
	checkValid();
	checkUser();
	checkMail();
}

function calendar(){
	var b = document.querySelector('input[name="birthD"]');
	b.onfocus = function(){
		this.type = "date";
		setMinDate();
	};
	b.onblur = function(){
		if(this.value == "") this.type = "text";
		checkValid();
	};
}

function checkPassword(){
	var pass2 = document.querySelector('[name="pass2"]');
	var pass1 = document.querySelector('[name="pass"]');
	pass2.onkeyup = pass1.onkeyup = function(){
		passBorder(pass1,pass2);
	}
}

function passBorder(pass1, pass2){
	if (pass1.value != pass2.value){
		pass1.style.borderColor = pass2.style.borderColor = "#F44336";
		REGISTER.validate.pass = false;
		checkValid();
	}
	else{
		pass1.style.borderColor = pass2.style.borderColor = "lightGrey";
		REGISTER.validate.pass = true;
		if(pass2.value != "") checkValid();
	}
}

function setInputError(obj,str){
	obj.setCustomValidity(str);
	obj.reportValidity();
}

function checkUser(){
	var userDiv = document.querySelector('[name="user"]')
	userDiv.onblur = function(){
		$.ajax({
			url: "register",
			type: "get",
			data: "checkUser=true&user="+ this.value,
			success: function(response) {
				if(response == "repeat"){
					userDiv.style.borderColor = "#F44336";
					REGISTER.validate.user = false;
					setInputError(userDiv, "This user is already registered!");
					checkValid();
				}
				else{
					userDiv.style.borderColor = "lightGrey";
					if(userDiv.value != "") REGISTER.validate.user = true;
					checkValid();
					if(userDiv.value != "")
						setInputError(userDiv, "");		
				}
			},
			error: function(xhr) {
    			//Do Something to handle error
    		}
    	});
	};
}

function checkMail(){
	var mailDiv = document.querySelector('[name="mail"]')
	mailDiv.onblur = function(){
		$.ajax({
			url: "register",
			type: "get",
			data: "checkMail=true&mail="+ this.value,
			success: function(response) {
				if(response == "repeat"){
					mailDiv.style.borderColor = "#F44336";
					REGISTER.validate.mail = false;
					setInputError(mailDiv, "This mail is already registered!");
					checkValid();
				}
				else{
					mailDiv.style.borderColor = "lightGrey";
					if(mailDiv.value != "") REGISTER.validate.mail = true;
					checkValid();
					if(mailDiv.value != "")
						setInputError(mailDiv, "");
				}
			},
			error: function(xhr) {
    			//Do Something to handle error
    		}
    	});
	};
}

function checkValid(){
	var button = document.querySelector('#send');
	if(!REGISTER.validate.pass || !REGISTER.validate.mail || !REGISTER.validate.user) button.disabled = true;
	else button.disabled = false;
}

function setMinDate(){
	var now = new Date();
	var year = now.getFullYear() - 16;
	var month = (now.getUTCMonth() + 1 >= 10 ? "" : "0") + (now.getUTCMonth() + 1);
	var day = (now.getDate() >= 10 ? "" : "0") + now.getDate();
	document.querySelector('[name = birthD]').max = year + "-" + month + "-" +  day;
}

function submitRegister(form){
	  event.preventDefault();
	  $.ajax({
			url: "register",
			type: "post",
			data: "register=true&" + $( form ).serialize(),
			success: function(response, status, request) {
				var container = document.querySelector('.mainCont'); 
				container.innerHTML = response;
				str = document.querySelector(".type").innerText.toLowerCase();
				str = str.replace(/\b\w/g, l => l.toUpperCase());
				document.title = str + " - Hackeet";
			},
			error: function(xhr) {
    			//Do Something to handle error
    		}
    	});
}
