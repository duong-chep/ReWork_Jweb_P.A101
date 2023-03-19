function check() {
    var userName = document.getElementById("userName");
    var email = document.getElementById("email");
    var password = document.getElementById("password");
    var rePassword = document.getElementById("rePassword");
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

    if (!setBorderColor(userName, 3, 30)) {
        message.innerText = "User name must be 3 to 30 characters";
        return false;
    }
    if (!setBorderColor(email, 5, 255)) {
        message.innerText = "Email must be more  to 5 characters";
        return false;
    }
    if (!setBorderColor(password, 8, 30)) {
        message.innerText = "Password must be 8 to 30 characters";
        return false;
    }
    if (!setBorderColor(rePassword, 8, 30)) {
        message.innerText = "Re password must be 8 to 30 characters";
        return false;
    }
    if (password.value != rePassword.value) {
        message.innerText = "Repassword not equals password";
        rePassword.style.borderColor = "red";
        rePassword.value = "";
        rePassword.focus();
        return false;
    }
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