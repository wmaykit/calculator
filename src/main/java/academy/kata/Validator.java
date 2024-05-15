package academy.kata;

import academy.kata.exceptions.FormatException;

public class Validator {
    private final String arabRegex = "^\\s*([0-9]{1,2})\\s*([+\\-/*])\\s*([0-9]{1,2})\\s*$";
    private final String romanRegex = "^\\s*([IVX]+)\\s*([+\\-/*])\\s*([IVX]+)\\s*$";

    public void validate(String expression) {
        validateFormat(expression);
    }

    private void validateFormat(String expression) {
        if (!(expression.matches(arabRegex) || expression.matches(romanRegex))) {
            throw new FormatException(expression);
        }
    }
}
