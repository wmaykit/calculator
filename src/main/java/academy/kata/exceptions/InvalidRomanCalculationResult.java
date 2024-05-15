package academy.kata.exceptions;

public class InvalidRomanCalculationResult extends RuntimeException{
    public InvalidRomanCalculationResult() {
        super("The result must be greater than zero for Roman numbers");
    }
}
