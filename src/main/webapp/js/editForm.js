$(document).ready(function () {
    function check() {
        var firstName = document.getElementById("firstName");
        var lastName = document.getElementById("lastName");
        var phone = document.getElementById("phone");
        var decription = document.getElementById("description");
        var message = document.getElementById("message");

        var form = document.forms[1];
        var n = form.length;

        for (let index = 0; index < n; index++) {
            if (form[index].value == "") {
                message.innerText = "The field have not empty";
                form[index].focus();
                return false;
            }

        }

        if (!setBorderColor(firstName, 3, 30)) {
            message.innerText = "First name must be 3 to 30 characters";
            return false;
        }
        if (!setBorderColor(lastName, 3, 30)) {
            message.innerText = "Last name must be 3 to 30 characters";
            return false;
        }
        if (!setBorderColor(phone, 9, 13)) {
            message.innerText = "Phone must be 9 to 13 characters";
            return false;
        }
        if (!setBorderColor(decription, 1, 200)) {
            message.innerText = "Decription must less 200 characters";
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

    $("#btn-edit").click(function () {
    	if(!check())
    		return false;
        var firstName = $("#firstName").val();
        var lastName = $("#lastName").val();
        var phone = $("#phone").val();
        var description = $("#description").val();
        $.post({
            url: "/JWEB_P.A101_DuongHM/edit",
            data: {
                firstName: firstName,
                lastName: lastName,
                phone: phone,
                description: description
            },
            success: function (response) {
                $("#bodyRightContent").html(response);
            }
        });
    });
    
    
});

