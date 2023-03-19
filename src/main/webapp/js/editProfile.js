$(document).ready(function(){
	
    $.get({
        url:"/ReWork_Jweb_P.A101/editForm.jsp",
        success:function(response){
            $('#editForm').html(response);
        }
    })
})