import academy.kata.Validator;
import academy.kata.exceptions.FormatException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class TestValidator {
    private final Validator validator = new Validator();

    @Test
    public void positiveFormatValidationArabExpressions() {
        assertDoesNotThrow(() -> validator.validate("1+1"), "without spaces");
        assertDoesNotThrow(() -> validator.validate("4 + 10"), "spaces on the side");
        assertDoesNotThrow(() -> validator.validate("4+10 "), "space in the end");
        assertDoesNotThrow(() -> validator.validate(" 4+10 "), "begin from space");
        assertDoesNotThrow(() -> validator.validate(" 4 + 10 "), "space on the side, in end, and begin from tab");
        assertDoesNotThrow(() -> validator.validate("\tIV\t+\tX\t"), "tab on the side, in end, and begin from tab");
    }

    @Test
    public void positiveFormatValidationRomanExpressions() {
        assertDoesNotThrow(() -> validator.validate("I+I"), "without spaces");
        assertDoesNotThrow(() -> validator.validate("IV + X"), "spaces on the side");
        assertDoesNotThrow(() -> validator.validate("IV+X "), "space in the end");
        assertDoesNotThrow(() -> validator.validate(" IV+X "), "begin from space");
        assertDoesNotThrow(() -> validator.validate(" I + II "), "space on the side, in end, and begin from tab");
        assertDoesNotThrow(() -> validator.validate("\tIV\t+\tX\t"), "tab on the side, in end, and begin from tab");
    }

    @Test
    public void negativeFormatValidationArabExpression() {
        assertThrows(FormatException.class, () -> validator.validate(""), "empty string");
        assertThrows(FormatException.class, () -> validator.validate("1"), "one number");
        assertThrows(FormatException.class, () -> validator.validate("1 1"), "without operator");
        assertThrows(FormatException.class, () -> validator.validate("1+1+1"), "two operations");
        assertThrows(FormatException.class, () -> validator.validate("1a+1"), "char in number");
        assertThrows(FormatException.class, () -> validator.validate("1+1a"), "char in number");
        assertThrows(FormatException.class, () -> validator.validate("1I+1"), "roman number with arab");
        assertThrows(FormatException.class, () -> validator.validate("1+1V"), "roman number with arab");
        assertThrows(FormatException.class, () -> validator.validate("1_1"), "invalid operator");
        assertThrows(FormatException.class, () -> validator.validate("1a1"), "invalid operator");
    }

    @Test
    public void negativeFormatValidationRomanExpression() {
        assertThrows(FormatException.class, () -> validator.validate(""), "empty string");
        assertThrows(FormatException.class, () -> validator.validate("I"), "one number");
        assertThrows(FormatException.class, () -> validator.validate("I I"), "without operator");
        assertThrows(FormatException.class, () -> validator.validate("V+X+I"), "two operations");
        assertThrows(FormatException.class, () -> validator.validate("Ia+I"), "char in number");
        assertThrows(FormatException.class, () -> validator.validate("V+VIa"), "char in number");
        assertThrows(FormatException.class, () -> validator.validate("VI1+IX"), "roman number with arab");
        assertThrows(FormatException.class, () -> validator.validate("I+1V"), "roman number with arab");
        assertThrows(FormatException.class, () -> validator.validate("I_I"), "invalid operator (symbol)");
        assertThrows(FormatException.class, () -> validator.validate("IaI"), "invalid operator (char)");
    }
}
