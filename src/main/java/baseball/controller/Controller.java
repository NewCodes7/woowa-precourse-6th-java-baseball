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
        Computer computer = new Computer();
        User user = new User();
        String userNumber = user.setUserNumber(InputView.readLine());
        String computerNumber = computer.setComputerNumber();
        Umpire umpire = new Umpire(computerNumber);
        Map<String, Integer> result = umpire.judge(userNumber);
        OutputView.printAttemptResult(result);
        // 계속 입력 받아야 함. 게임 종료할 때까지
    }
}
