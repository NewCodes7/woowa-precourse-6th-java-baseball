package baseball.constant;

import java.util.HashSet;
import java.util.Set;

public class Validator {
    public static final int NUMBER_LENGTH = 3;

    public static boolean validateNumber(String input) {
        validateInteger(input);
        validateLength(input);
        validateUnique(input);
        return true;
    }

    private static void validateInteger(String input) {
        try {
            Integer.parseInt(input);
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException();
        }
    }

    private static void validateLength(String input) {
        if(input.length() != NUMBER_LENGTH) {
            throw new IllegalArgumentException();
        }
    }

    private static void validateUnique(String input) {
        Set<Character> uniqueUserDigit = new HashSet<>();
        for (char digit : input.toCharArray()) {
            if (!uniqueUserDigit.add(digit)) {
                throw new IllegalArgumentException();
            }
        }
    }
}
