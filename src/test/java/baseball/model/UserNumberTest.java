package baseball.model;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class UserNumberTest {
    @Test
    void 예외_정수가_아닌_경우() {
        UserNumber userNumber = new UserNumber();
        assertThatThrownBy(() -> userNumber.setUserNumber("일이삼"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 예외_3자리가_아닌_경우() {
        UserNumber userNumber = new UserNumber();
        assertThatThrownBy(() -> userNumber.setUserNumber("1234"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 예외_숫자가_중복되는_경우() {
        UserNumber userNumber = new UserNumber();
        assertThatThrownBy(() -> userNumber.setUserNumber("121"))
                .isInstanceOf(IllegalArgumentException.class);
    }
}