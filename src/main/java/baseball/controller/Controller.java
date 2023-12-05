package baseball.controller;

import baseball.model.Computer;
import baseball.model.Umpire;
import baseball.model.User;
import baseball.view.InputView;
import baseball.view.OutputView;
import java.util.Map;

public class Controller {
    public void excute() {
        OutputView.printGameStart();
        compareNumbersRepeatedly();
    }

    private static void compareNumbersRepeatedly() {
        Computer computer = new Computer();
        User user = new User();
        String computerNumber = computer.setComputerNumber();
        Umpire umpire = new Umpire(computerNumber);
        System.out.println(computerNumber);
        boolean areNumbersEqual = false;
        while(!areNumbersEqual) {
            String userNumber = user.setUserNumber(InputView.readUserNumber());
            Map<String, Integer> result = umpire.judge(userNumber);
            OutputView.printAttemptResult(result);
            if(result.get("strike") == 3) {
                areNumbersEqual = true;
                OutputView.printGameExit();
                exitOrRestart();
            }
        }
    }

    private static void exitOrRestart() {
        if(InputView.readGameExitOrRestart().equals("1")) {
            compareNumbersRepeatedly();
        }
    }
}
