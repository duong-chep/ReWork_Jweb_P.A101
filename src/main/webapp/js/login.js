function validateDataForm(){
    var email = document.getElementById("email");
    var password = document.getElementById("password");
    var regex = /[a-z][a-zA-Z0-9]+\@[a-z]+\.com/;
    var message = document.getElementById("message");
    var form = document.forms[0];
    var n = form.length;

    for (let index = 0; index < n; index++) {
        if(form[index].value == ""){
            message.innerText = "The field have not empty";
            form[index].focus();
            return false;
        }
        
    }

    if(!regex.test(email.value) || !setBorderColor(email,5,50)){
        message.innerText = "Email not invalid";
        email.style.borderColor = "red";
        return false;
    }

/* 
	if(!setBorderColor(password,8,30)){
        message.innerText = "Password must be 8 to 30 character";
        return false;
    }
 */
    
    return true;
}


function setBorderColor(element, vMin, vMax) {
    var leng = element.value.length;
    if (leng < vMin || leng > vMax) {
        element.style.borderColor = "red";
        element.focus();
        return false;
    } else {
        element.style.borderColor = "green";
        return true;
    }
}
