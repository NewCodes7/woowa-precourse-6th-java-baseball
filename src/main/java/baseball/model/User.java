package baseball.model;

import java.util.HashSet;
import java.util.Set;

public class User {
    private static String userNumber;

    public void setUserNumber(String input) {
        if(validate(input)) {
            userNumber = input;
        }
    }

    public static boolean validate(String input) {
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
        if(input.length() != 3) {
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
