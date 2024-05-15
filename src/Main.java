package src;

import java.util.Scanner;

class Main {
    private static final Validator validator = new Validator();

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println(calc(scanner.nextLine()));
        }
    }

    public static String calc(String input) {
        validator.validate(input);
        return new Parser(input).parse().calculate();
    }
}