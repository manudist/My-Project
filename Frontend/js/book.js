$(document).ready(function () {
    loadBooks();
    populateAuthorSelect()
  });
  
  function loadBooks(){
    $.ajax({
      url: "http://localhost:8085/book"
    }).then(function (books) {
      books.forEach(element => addBookToTable(element));
    });
  }
  function populateAuthorSelect(){
    $.ajax({
      url: "http://localhost:8085/author"
    }).then(function (authors) {
      authors.forEach(element => addAuthorToSelect(element));
    });
  }
  function reloadBooks(){
    $("#bookTableBody").empty();
    loadBooks();
  }
  
  function addBookToTable(book) {
    $("#bookTableBody").append("<tr><td>" + book.title + "</td><td>" + book.creationDate + "</td><td>" + book.modificationDate + "</td><td>" + book.id + "</td><td>" + book.author.name + "</td>")
  }
  
  function addAuthorToSelect(author){
    $("#book-author").append("<option value=\""+author.id+"\">"+author.name+"</option>")
  }

  function createBook(event) {
    $.ajax({
      url: "http://localhost:8085/book",
      type: "POST",
      data: JSON.stringify({
        title:event.target.elements.bookTitle.value,
        author:{
          id:event.target.elements.bookAuthor.value
        }

      }),
      contentType: "application/json; charset=utf-8",
      dataType: "json",
      success:function(){reloadBooks()}
    })
    event.preventDefault();
  }