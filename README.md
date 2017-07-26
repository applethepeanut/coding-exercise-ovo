# Coding challenge

A simple SBT application for a coding challenge.

## The aim

The application reads an AddressBook file and answers the following questions in the format of ```<question number>. <answer>```

1. How many males are in the address book?
2. Who is the oldest person in the address book?
3. How many days older is Bill than Paul?

### Decisions and assumptions

I wanted to refrain from throwing exceptions in the creation of a Person, so the ```apply``` def returns an optional Person.

## Testing

Run SBT test:
 
```
sbt test
```

## Running

Run SBT test:
 
```
sbt run
```