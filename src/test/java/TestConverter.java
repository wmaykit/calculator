import academy.kata.Converter;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class TestConverter {

    @Test
    public void shouldBeCorrectConvert(){
        assertEquals(1, Converter.romanToArabic("I"));
        assertEquals(2, Converter.romanToArabic("II"));
        assertEquals(3, Converter.romanToArabic("III"));
        assertEquals(4, Converter.romanToArabic("IV"));
        assertEquals(5, Converter.romanToArabic("V"));
        assertEquals(6, Converter.romanToArabic("VI"));
        assertEquals(7, Converter.romanToArabic("VII"));
        assertEquals(8, Converter.romanToArabic("VIII"));
        assertEquals(9, Converter.romanToArabic("IX"));
        assertEquals(10, Converter.romanToArabic("X"));
    }

    @Test
    public void shouldBeReturnNull(){
        assertNull(Converter.romanToArabic("IIII"));
        assertNull(Converter.romanToArabic("IIV"));
        assertNull(Converter.romanToArabic("VIIII"));
        assertNull(Converter.romanToArabic("IIX"));
        assertNull(Converter.romanToArabic("XV"));
        assertNull(Converter.romanToArabic("IVX"));
        assertNull(Converter.romanToArabic("XI"));
    }
}
