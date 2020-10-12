$(document).ready(function () {
    loadReaders()
  });
  
  function loadReaders(){
    $.ajax({
      url: "http://localhost:8085/reader"
    }).then(function (readers) {
      readers.forEach(element => addReaderToTable(element));
    });
  }
  
  function reloadReaders(){
    $("#authorTableBody").empty();
    loadReaders();
  }
  
  function addReaderToTable(reader) {
    $("#readerTableBody").append("<tr><td>" + reader.name + "</td><td>" + reader.creationDate + "</td><td>" + reader.modificationDate + "</td><td>" + reader.id + "</td><td>" + reader.birthdate + "</td><td>" + reader.birthplace + "</td></tr>")
  }
  
  function createReader(event) {
    $.ajax({
      url: "http://localhost:8085/reader",
      type: "POST",
      data: JSON.stringify({
        name: event.target.elements.readerName.value,
        birthplace: event.target.elements.readerBirthplace.value,
        birthdate: event.target.elements.readerBirthdate.value,
        description: event.target.elements.readerDescription.value
      }),
      contentType: "application/json; charset=utf-8",
      dataType: "json",
      success:function(){reloadReaders()}
    })
    event.preventDefault();
  }