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
        manageGame();
    }

    private static void manageGame() {
        String computerNumber = new Computer().setComputerNumber();
        System.out.println(computerNumber); //테스트용 임시 코드
        boolean areNumbersEqual = false;
        while(!areNumbersEqual) {
            String userNumber = new User().setUserNumber(InputView.readUserNumber());
            Map<String, Integer> result = new Umpire(computerNumber).judge(userNumber);
            OutputView.printAttemptResult(result);
            if(result.get("strike") == 3) {
                areNumbersEqual = true;
            }
        }
        OutputView.printGameExit();
        exitOrRestart();
    }

    private static void exitOrRestart() {
        if(InputView.readGameExitOrRestart().equals("1")) {
            manageGame();
        }
    }
}
