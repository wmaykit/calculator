package academy.kata;

import academy.kata.exceptions.FormatException;
import academy.kata.exceptions.InvalidNumber;

import java.util.function.Predicate;

public class Validator {
    private final String ARAB_REGEXP = "^\\s*([0-9]{1,2})\\s*([+\\-/*])\\s*([0-9]{1,2})\\s*$";
    private final String ROMAN_REGEXP = "^\\s*([IVX]+)\\s*([+\\-/*])\\s*([IVX]+)\\s*$";

    public void validate(String expression) {
        validateFormat(expression);
        validateNumbers(expression.matches(ARAB_REGEXP) ? this::validateArabicNumber : this::validateRomanNumber, expression);
    }

    private void validateFormat(String expression) {
        if (!(expression.matches(ARAB_REGEXP) || expression.matches(ROMAN_REGEXP))) {
            throw new FormatException(expression);
        }
    }

    private void validateNumbers(Predicate<String> validationFn, String expression) {
        for (String num : parseNumbers(expression)) {
            if (!validationFn.test(num)) {
                throw new InvalidNumber(num);
            }
        }
    }

    private String[] parseNumbers(String expression) {
        return expression.replaceAll("\\s", "").split("[+\\-/*]");
    }

    private boolean validateArabicNumber(String numberString) {
        return Integer.parseInt(numberString) <= 10;
    }

    private boolean validateRomanNumber(String numberString) {
        return Converter.romanToArabic(numberString) != null;
    }
}
