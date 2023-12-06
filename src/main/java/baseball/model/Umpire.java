package baseball.model;

import baseball.constant.BaseballOutcome;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Umpire {
    public static final int ZERO_INITIALIZE = 0;
    public static final String NUMBER_SPLIT_REGEX = "";
    public static final int COUNT_PLUS = 1;
    private static List<String> splitComputerNumber;

    public Umpire(String computerNumber) {
        splitComputerNumber = Arrays.asList(computerNumber.split(NUMBER_SPLIT_REGEX));
    }

    public Map<String, Integer> judge(String userNumber) {
        List<String> splitUserNumber = Arrays.asList(userNumber.split(NUMBER_SPLIT_REGEX));
        Map<String, Integer> result = new HashMap<>();
        result.put(BaseballOutcome.STRIKE.getEnglishName(), ZERO_INITIALIZE);
        result.put(BaseballOutcome.BALL.getEnglishName(), ZERO_INITIALIZE);
        for (String computerNumberDigit : splitComputerNumber) {
            boolean isSameDigit = splitUserNumber.contains(computerNumberDigit);
            boolean isSameIndex = splitComputerNumber.indexOf(computerNumberDigit) == splitUserNumber.indexOf(computerNumberDigit);
            result = isStrike(result, isSameDigit, isSameIndex);
            result = isBall(result, isSameDigit, isSameIndex);
        }
        return result;
    }

    private static Map<String, Integer> isStrike(Map<String, Integer> result, boolean isSameDigit, boolean isSameIndex) {
        if(isSameDigit && isSameIndex) {
            int currentStrikeNumber = result.get(BaseballOutcome.STRIKE.getEnglishName());
            result.put(BaseballOutcome.STRIKE.getEnglishName(), currentStrikeNumber + COUNT_PLUS);
        }
        return result;
    }

    private static Map<String, Integer> isBall(Map<String, Integer> result, boolean isSameDigit, boolean isSameIndex) {
        if(isSameDigit && !isSameIndex) {
            int currentBallNumber = result.get(BaseballOutcome.BALL.getEnglishName());
            result.put(BaseballOutcome.BALL.getEnglishName(), currentBallNumber + COUNT_PLUS);
        }
        return result;
    }
}
