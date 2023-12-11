var wrapperDiv = document.createElement('div');
wrapperDiv.className = 'wrapper';

var heading = document.createElement('h1');
heading.textContent = 'Ежедневник:';
wrapperDiv.appendChild(heading);

var inputElement = document.createElement('input');
inputElement.type = 'text';
inputElement.id = 'inputId';
inputElement.placeholder = 'введите задачу';
wrapperDiv.appendChild(inputElement);

var addButton = document.createElement('button');
addButton.id = 'buttonId';
addButton.className = 'add';
addButton.textContent = 'Добавить';
wrapperDiv.appendChild(addButton);

var listElement = document.createElement('ol');
listElement.id = 'listId';
wrapperDiv.appendChild(listElement);

document.body.appendChild(wrapperDiv);

var buttonElement = document.getElementById('buttonId');
var listElement = document.getElementById('listId');

buttonElement.addEventListener('click', function() {
  var inputElement = document.getElementById('inputId');
  var inputValue = inputElement.value;
  var listItem = document.createElement('li');
  if(inputValue == '') {
  alert("Строка не может быть пустой!");
  throw new Error();
  }

  listItem.textContent = inputValue;
  var checkbox = document.createElement('input');
  checkbox.type = 'checkbox';
  listItem.appendChild(checkbox);
  
  var deleteButton = document.createElement('button');
  deleteButton.textContent = 'Удалить';
  deleteButton.addEventListener('click', function() {
    listItem.remove();
  })
  
  listItem.appendChild(deleteButton);
  
  listElement.appendChild(listItem);
})
