package academy.kata;

import academy.kata.exceptions.InvalidOperator;
import academy.kata.exceptions.InvalidRomanCalculationResult;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class OperationTest {

    @Test
    public void shouldBeCorrectCalculationArabicNumbers() {
        assertEquals("2", new Operation(DigitsType.ARABIC, new int[]{1, 1}, '+').calculate());
        assertEquals("-1", new Operation(DigitsType.ARABIC, new int[]{1, 2}, '-').calculate());
        assertEquals("4", new Operation(DigitsType.ARABIC, new int[]{2, 2}, '*').calculate());
        assertEquals("100", new Operation(DigitsType.ARABIC, new int[]{10, 10}, '*').calculate());
        assertEquals("3", new Operation(DigitsType.ARABIC, new int[]{7, 2}, '/').calculate());
    }

    @Test
    public void shouldBeCorrectCalculationRomanNumbers() {
        assertEquals("II", new Operation(DigitsType.ROMAN, new int[]{1, 1}, '+').calculate());
        assertEquals("IV", new Operation(DigitsType.ROMAN, new int[]{2, 2}, '*').calculate());
        assertEquals("C", new Operation(DigitsType.ROMAN, new int[]{10, 10}, '*').calculate());
        assertEquals("III", new Operation(DigitsType.ROMAN, new int[]{7, 2}, '/').calculate());
        assertEquals("I", new Operation(DigitsType.ROMAN, new int[]{3, 2}, '-').calculate());
    }

    @Test
    public void shouldBeThrowException() {
        assertThrows(
                InvalidOperator.class,
                () -> new Operation(DigitsType.ARABIC, new int[]{1, 1}, '%').calculate(),
                "invalid operator"
        );
        assertThrows(
                InvalidRomanCalculationResult.class,
                () -> new Operation(DigitsType.ROMAN, new int[]{3, 4},'-').calculate(),
                "The calculation result for Roman numerals cannot be less than one"
        );
    }
}