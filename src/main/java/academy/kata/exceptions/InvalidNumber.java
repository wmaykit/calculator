package academy.kata.exceptions;

public class InvalidNumber extends RuntimeException{
    public InvalidNumber(String number) {
        super("Invalid number - '%s'".formatted(number));
    }
}
