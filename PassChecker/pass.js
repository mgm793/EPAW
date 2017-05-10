
var button;
var message;
var pass;


var App = {

    init: function(){
        button = document.querySelector("#subButton");
        message = document.querySelector(".mess");
        App.addButtonListeners();
    },

    addButtonListeners: function(){
        button.addEventListener("click", function(){
            pass = document.querySelector("#passOne").value; 
            App.checkPassStrength(pass);
        });
    },

    scorePassword: function(pass) {
        //contraseña en blanco.
        if (pass.length == 0) {
            mess.innerHTML = "";
            return 0;
        }
 
        //Expresion regular a seguir.
        var regex = new Array();
        regex.push("[A-Z]"); //mayusculas
        regex.push("[a-z]"); //minusculas
        regex.push("[0-9]"); //numeros
        regex.push("[$@$!%*#?&]"); //caracteres.
 
        //Aqui guardo el Score final de la password
        var score = 0;
 
        //Compruebo la pass con cada una de las reglas de antes
        for (var i = 0; i < regex.length; i++) {
            if (new RegExp(regex[i]).test(pass)) {
                score++;
            }
        }

        //Miro la longitud y le doy algo de importancia
        if (score > 2 && pass.length > 8) {
            score++;
        }

        return score;
    },

    checkPassStrength:function(pass) {
        var score = App.scorePassword(pass);
        var color = "";
        var strength = "";
        switch (score) {
            case 0:
            case 1:
                strength = "Weak";
                color = "red";
                break;
            case 2:
                strength = "Good";
                color = "darkorange";
                break;
            case 3:
            case 4:
                strength = "Strong";
                color = "green";
                break;
            case 5:
                strength = "Very Strong";
                color = "darkgreen";
                break;
        }
        message.innerHTML = strength;
        message.style.display = "block"; 
        message.style.background = color;
    }
}

App.init();