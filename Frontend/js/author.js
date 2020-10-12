$(document).ready(function () {
  loadAuthors()
  $("#authorTableBody").on("click","tr",function(event){
console.log(event.currentTarget)
  moveElements(event.currentTarget);
  });
});

function loadAuthors(){
  $.ajax({
    url: "http://localhost:8085/author"
  }).then(function (authors) {
    authors.forEach(element => addAuthorToTable(element));
  });
}

function reloadAuthors(){
  $("#authorTableBody").empty();
  loadAuthors();
}

function addAuthorToTable(author) {
  $("#authorTableBody").append("<tr><td>" + author.name + "</td><td>" + author.creationDate + "</td><td>" + author.modificationDate + "</td><td>" + author.id + "</td><td>" + author.birthdate + "</td><td>" + author.birthplace + "</td></tr>")
}


function moveElements(element){
  var cells = element.getElementsByTagName("td");
  document.getElementById("author-name").value=cells[0].innerText;
  document.getElementById("author-birthdate").value=cells[4].innerText;
  document.getElementById("author-birthplace").value=cells[5].innerText;
}


function createAuthor(event) {
  $.ajax({
    url: "http://localhost:8085/author",
    type: "POST",
    data: JSON.stringify({
      name: event.target.elements.authorName.value,
      birthplace: event.target.elements.authorBirthplace.value,
      birthdate: event.target.elements.authorBirthdate.value,
      description: event.target.elements.authorDescription.value
    }),
    contentType: "application/json; charset=utf-8",
    dataType: "json",
    success:function(){reloadAuthors()}
  })
  event.preventDefault();
}
