package baseball.view;

import java.util.Map;

public class OutputView {
    public static void printGameStart() {
        System.out.println("숫자 야구 게임을 시작합니다.");
    }

    public static void printAttemptResult(Map<String, Integer> result) {
        int strike = result.get("strike");
        int ball = result.get("ball");
        System.out.print("");
        if(strike != 0) {
            System.out.print(strike + "스트라이크");
        }
        if(ball != 0) {
            System.out.print(ball + "볼");
        }
        if(strike == 0 && ball == 0) {
            System.out.print("낫싱");
        }
    }
}
