# Calculator
A simple implementation of a calculator. You can perform one operation on two numbers from 1 to 10. Arabic and Roman numerals are supported.

**Version with tests and maven support located in [calculator_with_tests](https://github.com/wmaykit/calculator/tree/calculator_with_tests) branch**

## Architecture
This application has a layered architecture. The first layer is expression validation (Validator). Then the clean data goes to the parsing layer (Parser). And the last layer is the layer where the result is calculated (Operation).

## Restrictions
* Numbers can only be from 1 to 10
* Only the following operations are supported - ***, /, +, -**.
* Computations can only occur on the same type of numbers(Arabic or Roman).
* If calculating Roman numerals, then the result cannot be less than I.

## Requirements
* Java 17

## Usage
1. clone this repo `git clone https://github.com/wmaykit/calculator.git`
2. move to calculator folder
3. compile to bytecode `javac src/* -d out`
4. run program `java -classpath out src.Main`
5. Input expression and press enter.

## 