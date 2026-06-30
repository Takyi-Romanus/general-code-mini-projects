// for single line comments

/* for multi line comments */ 

// let for declaring mutable variables

// const for declaring immutable variables

// data types
let pet = {
  name: "Fluffy",
  age: 3,
  type: "dog"
};
const crypticKey1= Symbol("saltNpepper");
const veryBigNumber = 1234567890123456789012345678901234567890n;

// concatenation
let fullName = firstName.concat(" ", lastName);

// sentence maker

let adjective;
let noun;
let verb;
let place;
let adjective2;
let noun2;
let firstStory;

adjective = "mighty";
noun = "dragon";
verb = "angry";
place = "cave";
adjective2 = "thin";
noun2 = "princess";

firstStory = "Once upon a time, there was a(n) " + adjective +" "+ noun + " who loved to eat "+ noun2+". The " +noun+ " lived in a "+ place +" and had "+adjective2+ " nostrils that blew fire when it was "+ verb+"."
console.log("First story: " +firstStory);

let secondStory;
adjective = "ugly";
noun = "Ogre";
verb = "angry";
place = "cave";
adjective2 = "";
noun2 = "princess";

secondStory = "Once upon a time, there was a(n) " + adjective+" " + noun + " who loved to eat "+ noun2+". The " +noun+ " lived in a "+ place +" and had "+adjective2+ " nostrils that blew fire when it was "+ verb+"."
console.log("Second story: " +secondStory);

// prompt
prompt("label", "placeholder text");


// Teacher chatbot
console.log("Hi there!");

const botName = "teacherBot";

const greeting = `My name is ${botName}.`;
console.log(greeting);

const subject = "JavaScript";
const topic = "strings";

const sentence = `Today, you will learn about ${topic} in ${subject}.`;
console.log(sentence);

const strLengthIntro = `Here is an example of using the length property on the word ${subject}.`;
console.log(strLengthIntro);

console.log(subject.length);

console.log(`Here is an example of using the length property on the word ${topic}.`);
console.log(topic.length);

console.log(`Here is an example of accessing the first letter in the word ${subject}.`);

console.log(subject[0]);

console.log(`Here is an example of accessing the second letter in the word ${subject}.`);
console.log(subject[1]);

console.log(`Here is an example of accessing the last letter in the word ${subject}.`);

const lastCharacter = subject[subject.length - 1];
console.log(lastCharacter);

const learningIsFunSentence = "Learning is fun.";

console.log("Here are examples of finding the positions of substrings in the sentence.");

console.log(learningIsFunSentence.indexOf("Learning"));

console.log(learningIsFunSentence.indexOf("fun"));
console.log(learningIsFunSentence.indexOf("learning"));

console.log("I hope you enjoyed learning today.")

//Strings
let letter = "A";
console.log(letter.charCodeAt(0));  // 65
let symbol = "!";
console.log(symbol.charCodeAt(0));  // 33
let char = String.fromCharCode(65);
console.log(char);  //  A
let char = String.fromCharCode(97);
console.log(char);  // a

// Test if a String Contains a Substring?
// includes() method: determines whether one string may be found within another
string.includes(searchValue);
let phrase = "JavaScript is awesome!";
let result = phrase.includes("awesome");

console.log(result);  // true

let text = "Hello, JavaScript world!";
let result = text.includes("JavaScript", 7);

console.log(result);  // true

// slice() method: extracts a section of a string and returns it as a new string, without modifying the original string.
string.slice(startIndex, endIndex);
let message = "Hello, world!";
let greeting = message.slice(0, 5);

console.log(greeting);  // Hello

let message = "Hello, world!";
let world = message.slice(7);

console.log(world);  // world!

let message = "JavaScript is fun!";
let lastWord = message.slice(-4);

console.log(lastWord);  // fun!

// String Inspector
const fccSentence = "freeCodeCamp is a great place to learn web development.";

console.log("Here are some examples of the includes() method:");

const hasFreeCodeCamp = fccSentence.includes("freeCodeCamp");
console.log(`fccSentence.includes("freeCodeCamp") returns ${hasFreeCodeCamp} because the word "freeCodeCamp" is in the sentence.`);

const hasJavaScript = fccSentence.includes("JavaScript");
console.log(`fccSentence.includes("JavaScript") returns ${hasJavaScript} because the word "JavaScript" is not in the sentence.`);

const hasLowercaseFCC = fccSentence.includes("freecodecamp");
console.log(`fccSentence.includes("freecodecamp") returns ${hasLowercaseFCC} because includes is case-sensitive.`);

const message = "Welcome to freeCodeCamp!";

console.log("Here are some examples of the slice() method:");

const platform = message.slice(11, 23);
console.log(`The word "${platform}" was sliced from the message.`);

const greetingWord = message.slice(0, 7);
console.log(`The first word is "${greetingWord}".`);

const endPunctuation = message.slice(-1);
console.log(`The ending punctuation mark is a "${endPunctuation}"`);

console.log("Workshop complete! You now know how to use includes() and slice().")

// String Formatting
let greeting = "Hello, World!";
let uppercaseGreeting = greeting.toUpperCase();
console.log(uppercaseGreeting);  // "HELLO, WORLD!"

let shout = "I AM LEARNING JAVASCRIPT!";
let lowercaseShout = shout.toLowerCase();
console.log(lowercaseShout);  // "i am learning javascript!"

let message = "   Hello!   ";
console.log(message); // "   Hello!   "
let trimmedMessage = message.trim();
console.log(trimmedMessage);  // "Hello!"

let trimmedStart = greeting.trimStart();
console.log(trimmedStart);  // "Hello!   "

let trimmedEnd = greeting.trimEnd();
console.log(trimmedEnd);  // "   Hello!"

// String formatter
