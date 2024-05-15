package src;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

class Converter {
    private static final Map<String, Integer> mapRomanToInt = Map.of(
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

    private static final Map<Integer, String> mapIntegerToRoman = new HashMap<>() {{
        put(1, "I");
        put(2, "II");
        put(3, "III");
        put(4, "IV");
        put(5, "V");
        put(6, "VI");
        put(7, "VII");
        put(8, "VIII");
        put(9, "IX");
        put(10, "X");
        put(40, "XL");
        put(50, "L");
        put(90, "XC");
        put(100, "C");
    }};

    static public Integer romanToInteger(String romanNumber) {
        return mapRomanToInt.get(romanNumber);
    }

    static public String intToRoman(int num) {
        StringBuilder stringBuilder = new StringBuilder();
        if (num < 1 || num > 100) {
            return null;
        }
        if (num < 40) {
            String romanTen = getRomanNumber(10);
            stringBuilder.append(romanTen.repeat(num / 10));
            stringBuilder.append(getRomanNumber(num % 10));
        } else if (num < 50) {
            stringBuilder.append(getRomanNumber(40));
            stringBuilder.append(getRomanNumber(num % 40));
        } else if (num == 50) {
            return getRomanNumber(50);
        } else if (num < 90) {
            stringBuilder.append(getRomanNumber(50));
            stringBuilder.append(intToRoman(num % 50));
        } else if (num < 100) {
            stringBuilder.append(getRomanNumber(90));
            stringBuilder.append(getRomanNumber(num % 90));
        } else if (num == 100) {
            return getRomanNumber(100);
        }
        return stringBuilder.toString();
    }

    private static String getRomanNumber(int num) {
        return Objects.toString(mapIntegerToRoman.get(num), "");
    }
}
