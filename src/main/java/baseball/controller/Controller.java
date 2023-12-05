package baseball.controller;

import baseball.model.Computer;
import baseball.model.Umpire;
import baseball.model.User;
import baseball.view.InputView;
import baseball.view.OutputView;

public class Controller {
    public void excute() {
        OutputView.printGameStart();
        Computer computer = new Computer();
        User user = new User();
        String userNumber = user.setUserNumber(InputView.readLine());
        String computerNumber = computer.setComputerNumber();
        Umpire umpire = new Umpire(computerNumber);
        umpire.judge(userNumber);
    }
}
