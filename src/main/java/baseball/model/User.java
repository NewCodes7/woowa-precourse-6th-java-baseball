package baseball.model;

import baseball.constant.Validator;

public class User {
    public String setUserNumber(String input) {
        String userNumber = null;
        if(Validator.validateNumber(input)) {
            userNumber = input;
        }
        return userNumber;
    }
}
