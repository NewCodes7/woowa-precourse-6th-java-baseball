package baseball.model;

import baseball.view.InputView;
import java.util.HashSet;
import java.util.Set;

public class UserNumber {
    private static String userNumber;

    public void setUserNumber(String input) {
        validate(input);
        userNumber = input;
    }

    private void validate(String input) {
        validateInteger(input);
        validateLength(input);
        validateUnique(input);
    }

    private void validateInteger(String input) {
        try {
            Integer.parseInt(input);
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException();
        }
    }

    private void validateLength(String input) {
        if(input.length() != 3) {
            throw new IllegalArgumentException();
        }
    }

    private void validateUnique(String input) {
        Set<Character> uniqueUserDigit = new HashSet<>();
        for (char digit : input.toCharArray()) {
            if (!uniqueUserDigit.add(digit)) {
                throw new IllegalArgumentException();
            }
        }
    }
}
