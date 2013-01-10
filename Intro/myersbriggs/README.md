# Program Flow

#### Main Method 
- *JOptionPane*'s are used to collect the name and the answer string to be provided to an instance of the *MyersBriggs* object

##### MyersBriggs class
- The *MyersBriggs* object stores the name in the name field and passes the answer string to an instance of *HandleResults*

##### HandleResults class
- *HandleResults* does the heavy lifting so to speak.
- The answer string is passed to the setAnswers method which uses a regular expression *Pattern* and *Matcher* to essentially takes 10 "bites" (substrings) of 7 characters each out of the result string.
- These 10 substrings of the answer string are saved into a String array before passing through a for each loop to break each section into an 4 different arrays representing the different dimensions of the Myers Briggs test.
- Next each of the 4 substrings is passed turned into a char array which is passed to an instance of the *Dimension* class.  (4 different Dimension objects)

##### Dimension class
- Each *Dimension* object stores a character array and returns the number of A characters that were passed to it.

##### HandleResults class (part 2)
- The makeDimensions method uses a multidimensional array and the return from each *Dimension* class to begin formatting what will become the output string.
* A call to the findType method with which group and how many A's were counted determines the letter for each group.
* Also several of the "shorthand if then else" aka ternary statements are used to further format the return string.

- *HandlResults* last function is to provide the formatted return string when the object name is used as a String parameter`*` in other methods by overriding the default toString method.  
    `*`I may very well be wrong about the background process here but it works

- The original *MyersBriggs* object sends the stored name and processed return string to a *JOptionPane* for display.
