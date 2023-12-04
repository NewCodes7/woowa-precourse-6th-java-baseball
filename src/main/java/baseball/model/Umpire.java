package baseball.model;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Umpire {
    private static List<String> splitComputerNumber;

    public Umpire(String computerNumber) {
        splitComputerNumber = Arrays.asList(computerNumber.split(""));
    }

    public Map<String, Integer> judge(String userNumber) {
        List<String> splitUserNumber = Arrays.asList(userNumber.split(""));
        Map<String, Integer> result = new HashMap<>();
        result.put("strike", 0);
        result.put("ball", 0);
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
            int currentStrikeNumber = result.get("strike");
            result.put("strike", currentStrikeNumber + 1);
        }
        return result;
    }

    private static Map<String, Integer> isBall(Map<String, Integer> result, boolean isSameDigit, boolean isSameIndex) {
        if(isSameDigit && !isSameIndex) {
            int currentBallNumber = result.get("ball");
            result.put("ball", currentBallNumber + 1);
        }
        return result;
    }
}
