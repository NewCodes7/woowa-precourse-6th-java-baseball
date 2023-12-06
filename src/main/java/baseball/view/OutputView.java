package baseball.view;

import java.util.Map;

public class OutputView {
    public static void printGameStart() {
        System.out.println("숫자 야구 게임을 시작합니다.");
    }

    public static void printAttemptStart() {
        System.out.print("숫자를 입력해주세요 : ");
    }

    public static void printAttemptResult(Map<String, Integer> result) {
        int strike = result.get("strike");
        int ball = result.get("ball");
        if (ball > 0) {
            System.out.print(ball + "볼");
            if (strike > 0) {
                System.out.print(" ");
            }
        }
        if (strike > 0) {
            System.out.print(strike + "스트라이크");
        }
        if (strike == 0 && ball == 0) {
            System.out.print("낫싱");
        }
        System.out.println();
    }

    public static void printGameExit() {
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
    }
}
