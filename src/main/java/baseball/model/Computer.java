package baseball.model;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Computer {
    public static final int NUMBER_LIMIT = 3;
    public static final int MIN_NUMBER = 1;
    public static final int MAX_NUMBER = 9;

    public String setComputerNumber() {
        List<Integer> computerNumber = new ArrayList<>();
        while (computerNumber.size() < NUMBER_LIMIT) {
            int randomNumber = Randoms.pickNumberInRange(MIN_NUMBER, MAX_NUMBER);
            if (!computerNumber.contains(randomNumber)) {
                computerNumber.add(randomNumber);
            }
        }
        return computerNumber.stream()
                .map(Object::toString)
                .collect(Collectors.joining());
    }
}
