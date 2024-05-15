package academy.kata;

import java.util.Map;

public class Converter {
    static final Map<String, Integer> mapRomanToArabic = Map.of(
            "I", 1,
            "II", 2,
            "III", 3,
            "IV", 4,
            "V", 5,
            "VI", 6,
            "VII", 7,
            "VIII", 8,
            "IX", 9,
            "X", 10
    );

    static public Integer romanToArabic(String romanNumber){
        return mapRomanToArabic.get(romanNumber);
    }
}
