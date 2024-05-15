package academy.kata;

import academy.kata.exceptions.InvalidOperator;
import academy.kata.exceptions.InvalidRomanCalculationResult;

public class Operation {
    private final DigitsType digitsType;
    private final int[] numbers;
    private final char operator;

    public Operation(DigitsType digitsType, int[] numbers, char operator){
        this.digitsType = digitsType;
        this.numbers = numbers;
        this.operator = operator;
    }

    public String calculate(){
        int calculated = execOperation();
        if (digitsType == DigitsType.ARABIC) {
            return Integer.toString(calculated);
        }
        String romanNumber = Converter.intToRoman(calculated);
        if (romanNumber == null) {
            throw new InvalidRomanCalculationResult();
        }
        return romanNumber;
    }

    private int execOperation() {
        return switch (operator) {
            case '*' -> numbers[0] * numbers[1];
            case '/' -> numbers[0] / numbers[1];
            case '+' -> numbers[0] + numbers[1];
            case '-' -> numbers[0] - numbers[1];
            default -> throw new InvalidOperator();
        };
    }
}
