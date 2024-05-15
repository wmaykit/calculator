import academy.kata.Converter;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class TestConverter {

    @Test
    public void shouldBeCorrectConvertRomanToInteger(){
        assertEquals(1, Converter.romanToInteger("I"));
        assertEquals(2, Converter.romanToInteger("II"));
        assertEquals(3, Converter.romanToInteger("III"));
        assertEquals(4, Converter.romanToInteger("IV"));
        assertEquals(5, Converter.romanToInteger("V"));
        assertEquals(6, Converter.romanToInteger("VI"));
        assertEquals(7, Converter.romanToInteger("VII"));
        assertEquals(8, Converter.romanToInteger("VIII"));
        assertEquals(9, Converter.romanToInteger("IX"));
        assertEquals(10, Converter.romanToInteger("X"));
    }

    @Test
    public void shouldBeReturnNullIfIncorrectRomanNumberOrHigherTenWhenConvertRomanToInteger(){
        assertNull(Converter.romanToInteger("IIII"));
        assertNull(Converter.romanToInteger("IIV"));
        assertNull(Converter.romanToInteger("VIIII"));
        assertNull(Converter.romanToInteger("IIX"));
        assertNull(Converter.romanToInteger("XV"));
        assertNull(Converter.romanToInteger("IVX"));
        assertNull(Converter.romanToInteger("XI"));
    }

    @Test
    public void shouldBeCorrectConvertIntToRoman(){
        assertEquals("I", Converter.intToRoman(1));
        assertEquals("II", Converter.intToRoman(2));
        assertEquals("III", Converter.intToRoman(3));
        assertEquals("IV", Converter.intToRoman(4));
        assertEquals("V", Converter.intToRoman(5));
        assertEquals("VI", Converter.intToRoman(6));
        assertEquals("VII", Converter.intToRoman(7));
        assertEquals("VIII", Converter.intToRoman(8));
        assertEquals("IX", Converter.intToRoman(9));
        assertEquals("X", Converter.intToRoman(10));
        assertEquals("XIX", Converter.intToRoman(19));
        assertEquals("XXXIX", Converter.intToRoman(39));
        assertEquals("XL", Converter.intToRoman(40));
        assertEquals("L", Converter.intToRoman(50));
        assertEquals("LI", Converter.intToRoman(51));
        assertEquals("LXXX", Converter.intToRoman(80));
        assertEquals("LXXXI", Converter.intToRoman(81));
        assertEquals("LXXXIX", Converter.intToRoman(89));
        assertEquals("XC", Converter.intToRoman(90));
        assertEquals("XCI", Converter.intToRoman(91));
        assertEquals("XCIX", Converter.intToRoman(99));
        assertEquals("C", Converter.intToRoman(100));
    }

    @Test
    public void shouldBeReturnNullIfNumberIsHigherHundredOrLessOneWhenConvertIntToRoman(){
        assertNull(Converter.intToRoman(-1));
        assertNull(Converter.intToRoman(0));
        assertNull(Converter.intToRoman(101));
    }
}
