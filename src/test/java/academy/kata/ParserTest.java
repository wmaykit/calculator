package academy.kata;

import academy.kata.exceptions.InvalidNumberOfNumbers;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ParserTest {
    @Test
    public void positiveParsingResult(){
        assertDoesNotThrow(() -> new Parser("1+1").parse(), "simple test");
        assertDoesNotThrow(() -> new Parser(" 1 + 1 ").parse(), "spaces");
        assertDoesNotThrow(() -> new Parser("I + X").parse(), "Roman expression");
    }

    @Test
    public void shouldBeThrowException(){
        assertThrows(NullPointerException.class, () -> new Parser("X+1").parse(),  "parser only works with validated data");
        assertThrows(InvalidNumberOfNumbers.class, () -> new Parser("1+1+2").parse(),  "current version work only with simple expression [NUM][operator][NUM]");
    }
}