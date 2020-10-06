$(document).ready(function () {
    
    $.ajax({
        url: "http://localhost:8085/book"
    }).then(function (books) {
        console.log(books)     
    });
    $("#logbutton").click(function(){console.log("click")})
});