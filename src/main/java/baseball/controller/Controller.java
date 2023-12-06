package baseball.controller;

import baseball.constant.BaseballOutcome;
import baseball.model.Computer;
import baseball.model.Umpire;
import baseball.model.User;
import baseball.view.InputView;
import baseball.view.OutputView;
import java.util.Map;

public class Controller {
    public static final int THREE_STRIKE = 3;
    public static final String RESTART_NUMBER = "1";

    public void excute() {
        OutputView.printGameStart();
        manageGame();
    }

    private static void manageGame() {
        String computerNumber = new Computer().setComputerNumber();
        System.out.println(computerNumber); //테스트용 임시 코드

        boolean areNumbersEqual = false;
        while(!areNumbersEqual) {
            String userNumber = new User().setUserNumber(InputView.readUserNumber());
            Map<String, Integer> result = new Umpire().judge(computerNumber, userNumber);
            OutputView.printAttemptResult(result);
            if(result.get(BaseballOutcome.STRIKE.getEnglishName()) == THREE_STRIKE) {
                areNumbersEqual = true;
            }
        }
        OutputView.printGameExit();
        exitOrRestart();
    }

    private static void exitOrRestart() {
        if(InputView.readGameExitOrRestart().equals(RESTART_NUMBER)) {
            manageGame();
        }
    }
}
