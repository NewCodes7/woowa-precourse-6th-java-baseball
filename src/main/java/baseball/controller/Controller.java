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
        Umpire umpire = new Umpire();
        Computer computer = new Computer();
        User user = new User();
        OutputView.printGameStart();
        manageGame(umpire, computer, user);
    }

    private static void manageGame(Umpire umpire, Computer computer, User user) {
        playGame(umpire, computer, user);
        exitOrRestart(umpire, computer, user);
    }

    private static void playGame(Umpire umpire, Computer computer, User user) {
        String computerNumber = computer.setComputerNumber();
        boolean areNumbersEqual = false;
        while(!areNumbersEqual) {
            String userNumber = user.setUserNumber(InputView.readUserNumber());
            Map<String, Integer> result = umpire.judge(computerNumber, userNumber);
            OutputView.printAttemptResult(result);
            if(result.get(BaseballOutcome.STRIKE.getEnglishName()) == THREE_STRIKE) {
                areNumbersEqual = true;
            }
        }
        OutputView.printGameExit();
    }

    private static void exitOrRestart(Umpire umpire, Computer computer, User user) {
        if(InputView.readGameExitOrRestart().equals(RESTART_NUMBER)) {
            manageGame(umpire, computer, user);
        }
    }
}
