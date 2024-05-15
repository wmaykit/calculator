package academy.kata;

import academy.kata.exceptions.InvalidNumberOfNumbers;

import java.util.Arrays;
import java.util.function.ToIntFunction;

import static academy.kata.RegexConstants.OPERATORS;
import static academy.kata.RegexConstants.WHITE_SPACES;

public class Parser {
    private final String expression;

    public Parser(String expression){
        this.expression = expression.replaceAll(WHITE_SPACES, "");
    }

    public Operation parse(){
        String[] numberStrings = expression.split(OPERATORS);
        DigitsType digitsType = isRomanNumber(numberStrings[0]) ? DigitsType.ROMAN : DigitsType.ARABIC;
        char operator = expression.charAt(numberStrings[0].length());
        int[] numbers =  parseNumbers(numberStrings, digitsType == DigitsType.ROMAN ? Converter::romanToInteger : Integer::parseInt);
        if (numbers.length != 2) {
            throw new InvalidNumberOfNumbers();
        }
        return new Operation(digitsType, numbers, operator);
    }

    private int[] parseNumbers(String[] numbers, ToIntFunction<String> converter) {
        return Arrays.stream(numbers).mapToInt(converter).toArray();
    }

    private boolean isRomanNumber(String number) {
        return Converter.romanToInteger(number) != null;
    }
}
