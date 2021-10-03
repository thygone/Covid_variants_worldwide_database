# Overview
    Not haveing written in Java for a while, I decided I needed a refresher on it. This program acts as that review, as well as at 
    the same time it can be used to simplify informatin on how prominant are each of the current known variants of covid.
    This program still has some problems but I am making a 

[CSE310 Covid Variant Database Code](https://youtu.be/zac7QIl5pgI)

# Data Analysis Results

Q.What on earth does it mean to have a covid variant sequenced? - A: still not sure but something to do with identifying streams of DNA/RNA
Q.What do I do with the information that is not needed? - A: I added a filter that ignored entries 0's in the "number_sequenced" column  
Q.how do I read a csv file? A: it separates everything with commas so read it like a text file than divide the lines up with those.

# Development Environment


I used visual studios Code and google for the most part. 

Using java I had to import a few libraries of Scanner, ParseExcepion, IOExceptin, and File
Additionally i made my own object to hold the Sample information. With this I had to make sure the main 
code and the Sample class were in the same package if I wanted them to work together..

# Useful Websites

{Make a list of websites that you found helpful in this project}
* [javaTpoint](https://www.javatpoint.com/java-tutorial)
* [stackoverflow](https://stackoverflow.com/questions)

# Future Work

{Make a list of things that you need to fix, improve, and add in the future.}
* Item 1 I should add arrays for the sample class so that I can combine each line from an individual sample to simplify the data displayed
* Item 2 experiment more with ways in how I can eliminate repeated lines of code. (make a diagram of my functions and how they connect)
* Item 3 I would like to add a way to better filter the location so that it is not as case sensitive.
* Item 4 clean up the code to look nicer.
# Item 5 handle null values in the file.
* Item 6 the location prompt function is throwing an exception about there not being another line.