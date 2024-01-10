$(document).ready(function() {
    
    
    $('#signin').click(function() {
        var email = $("#email").val()
        var password = $("#password").val()
        // console.log("gia tri " + email)
        $.ajax({
            method: "POST",
            url: "http://localhost:8080/login/signin",
            data: {
                 username: email, 
                 password: password 
                }
          })
            .done(function( msg ) {
                // console.log(email)
                console.log(msg)
                if(msg.data){
                    localStorage.setItem("token", msg.data)
                    window.location.href = "./index.html"
                }
                else 
                    alert("that bai");
            });
    });
});