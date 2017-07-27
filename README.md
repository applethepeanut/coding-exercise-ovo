# Coding challenge

A simple SBT application for a coding challenge.

## The aim

The application reads an AddressBook file and answers the following questions in the format of ```<question number>. <answer>```

1. How many males are in the address book?
2. Who is the oldest person in the address book?
3. How many days older is Bill than Paul?

### Decisions and assumptions

1. I decided to fail fast in that, when parsing the input file, any failure to produce any of the domain objects, will cause the program to terminate.
    I did this because I would rather know that I am processing data and getting consistent results rather than potentially ignoring domain objects that do not get generated correctly.
2. To keep things simple and iterative, I treated a person's name as a single string rather than splitting it into first and last names and worrying about parsing for now.
3. Regarding the oldest person, the result is an option in case the list is empty.
4. Regarding the number of days one person is older than another required search functionality, so to keep things simple ```find```, only works with an exact match.

## Testing

Run SBT test:
 
```
sbt test
```

## Running

To run the application and view the question results:
 
```
sbt run
```