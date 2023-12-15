package baseball.view;

import baseball.constant.BaseballOutcome;
import java.util.Map;

public class OutputView {
    public static final String START_GAME_MESSAGE = "숫자 야구 게임을 시작합니다.";
    public static final String INPUT_NUMBER_MESSAGE = "숫자를 입력해주세요 : ";
    public static final String GAME_EXIT_MESSAGE = "3개의 숫자를 모두 맞히셨습니다! 게임 종료";
    public static final String SPACE_FOR_STRIKE = " ";
    public static final int ZERO = 0;

    public static void printGameStart() {
        System.out.println(START_GAME_MESSAGE);
    }

    public static void printAttemptStart() {
        System.out.print(INPUT_NUMBER_MESSAGE);
    }

    public static void printAttemptResult(Map<String, Integer> result) {
        int strike = result.get(BaseballOutcome.STRIKE.getEnglishName());
        int ball = result.get(BaseballOutcome.BALL.getEnglishName());
        if (ball > ZERO) {
            System.out.print(ball + BaseballOutcome.BALL.getKoreanName());
            if (strike > ZERO) {
                System.out.print(SPACE_FOR_STRIKE);
            }
        }
        if (strike > ZERO) {
            System.out.print(strike + BaseballOutcome.STRIKE.getKoreanName());
        }
        if (strike == ZERO && ball == ZERO) {
            System.out.print(BaseballOutcome.NOTHING.getKoreanName());
        }
        System.out.println();
    }

    public static void printGameExit() {
        System.out.println(GAME_EXIT_MESSAGE);
    }
}
