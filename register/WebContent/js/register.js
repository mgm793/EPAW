var REGISTER = {
	init: function(){
		calendar();
		checkPassword();
		checkValid();
	},
	validate: {
		pass: false,
		user: false,
		mail: false
	}
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
		checkValid();
	}
}

function checkValid(){
	var button = document.querySelector('#send');
	if(!REGISTER.validate.pass) button.disabled = true;
	else button.disabled = false;
}

function setMinDate(){
	var now = new Date();
	var year = now.getFullYear() - 16;
	var month = (now.getUTCMonth() + 1 >= 10 ? "" : "0") + (now.getUTCMonth() + 1);
	var day = (now.getDay() >= 10 ? "" : "0") + now.getDay();
	document.querySelector('[name = birthD]').max = year + "-" + month + "-" +  day;
}