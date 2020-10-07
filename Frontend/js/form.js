
function createAuthor(event){
    /*$.post("http://localhost:8085/author",{
     name:event.target.elements.authorName.value
    });*/

    $.ajax({
        url:"http://localhost:8085/author",
        type:"POST",
        data:JSON.stringify({
            name:event.target.elements.authorName.value,
            birthplace:event.target.elements.authorBirthplace.value,
            birthdate:event.target.elements.authorBirthdate.value,
            description:event.target.elements.authorDescription.value
           }),
        contentType:"application/json; charset=utf-8",
        dataType:"json",
      })
    event.preventDefault();
}
