$(document).ready(function() {
    $.ajax({
        url: "http://localhost:8085/book"
    }).then(function (books) {
        books.forEach(element => addBookToTable(element)); 
    });
});
function addBookToTable(book){
    $("#bookTableBody").append("<tr><td>"+book.title+"</td><td>"+book.creationDate+"</td><td>"+book.modificationDate+"</td><td>"+book.id+"</td><td>"+book.author.name+"</td>")
}
$.ajax({
    url: "http://localhost:8085/author"
}).then(function (authors) {
    authors.forEach(element => addAuthorToTable(element)); 
});
function addAuthorToTable(author){
    $("#authorTableBody").append("<tr><td>"+author.name+"</td><td>"+author.creationDate+"</td><td>"+author.modificationDate+"</td><td>"+author.id+"</td><td>"+author.birthdate+"</td><td>"+author.birthplace+"</td></tr>")
}