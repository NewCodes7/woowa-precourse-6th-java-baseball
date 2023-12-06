package baseball.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Map;
import org.junit.jupiter.api.Test;

class UmpireTest {
    @Test
    void 스트라이크_테스트() {
        Umpire umpire = new Umpire();
        Map<String, Integer> result =  umpire.judge("123", "125");
        assertThat(result.get("strike")).isEqualTo(2);
        assertThat(result.get("ball")).isEqualTo(0);
    }

    @Test
    void 볼_테스트() {
        Umpire umpire = new Umpire();
        Map<String, Integer> result =  umpire.judge("123", "512");
        assertThat(result.get("strike")).isEqualTo(0);
        assertThat(result.get("ball")).isEqualTo(2);
    }

    @Test
    void 스트라이크_볼_테스트() {
        Umpire umpire = new Umpire();
        Map<String, Integer> result =  umpire.judge("123", "321");
        assertThat(result.get("strike")).isEqualTo(1);
        assertThat(result.get("ball")).isEqualTo(2);
    }
}