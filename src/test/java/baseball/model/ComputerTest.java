package baseball.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import baseball.constant.Validator;
import org.junit.jupiter.api.Test;

class ComputerTest {
    @Test
    void 컴퓨터_랜덤_숫자_생성() {
        Computer computer = new Computer();
        assertThat(Validator.validateNumber(computer.setComputerNumber())).isEqualTo(true);
    }
}