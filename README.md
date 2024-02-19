```js
function getBioInfo() {
  let name = "Abrar Shakhi";
  let age = 21;
  let study = "Computer science & engineering";
  let hobbies = ["coding", "drawing", "designing"];

  let bio = "";

  bio += "Hi, I'm " + name + ".\n";
  bio += "I'm " + age + " years old and I am studying " + study + ".\n";

  bio += "My hobbies include ";

  for (let i = 0; i < hobbies.length; i++) {
    if (i == hobbies.length - 1) {
      bio += "and " + hobbies[i] + ".\n";
    } else {
      bio += hobbies[i] + ", ";
    }
  }

  return bio;
}
```
