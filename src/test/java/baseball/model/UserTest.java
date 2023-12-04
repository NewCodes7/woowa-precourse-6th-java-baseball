package baseball.model;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.Test;

class UserTest {
    @Test
    void 예외_정수가_아닌_경우() {
        User user = new User();
        assertThatThrownBy(() -> user.setUserNumber("일이삼"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 예외_3자리가_아닌_경우() {
        User user = new User();
        assertThatThrownBy(() -> user.setUserNumber("1234"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 예외_숫자가_중복되는_경우() {
        User user = new User();
        assertThatThrownBy(() -> user.setUserNumber("121"))
                .isInstanceOf(IllegalArgumentException.class);
    }
}