package src;

import java.util.function.Predicate;

import static src.RegexConstants.ARAB_REGEXP;
import static src.RegexConstants.OPERATORS;
import static src.RegexConstants.ROMAN_REGEXP;
import static src.RegexConstants.WHITE_SPACES;

class Validator {


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
        return expression.replaceAll(WHITE_SPACES, "").split(OPERATORS);
    }

    private boolean validateArabicNumber(String numberString) {
        int num = Integer.parseInt(numberString);
        return num <= 10 && num > 0;
    }

    private boolean validateRomanNumber(String numberString) {
        return Converter.romanToInteger(numberString) != null;
    }
}
