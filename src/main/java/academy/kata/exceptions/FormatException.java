package academy.kata.exceptions;

public class FormatException extends RuntimeException {
    public FormatException(String expression) {
        super("'%s' - invalid format".formatted(expression));
    }
}
