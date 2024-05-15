package academy.kata;

public final class RegexConstants {
    static final String OPERATORS = "[+\\-*/]";
    static final String ARAB_REGEXP = "^\\s*[0-9]{1,2}\\s*%s\\s*([0-9]{1,2})\\s*$".formatted(OPERATORS);
    static final String ROMAN_REGEXP = "^\\s*[IVX]+\\s*%s\\s*[IVX]+\\s*$".formatted(OPERATORS);
    static final String WHITE_SPACES = "\\s";

    private RegexConstants(){}
}
