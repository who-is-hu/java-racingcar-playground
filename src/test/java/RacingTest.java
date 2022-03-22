import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class RacingTest {

    private MovingCondition condition = new AlwaysTrueCondition();

    @Test
    void Car_생성_테스트(){
        assertThat(Racing.createCars("test1,test2", condition).size()).isEqualTo(2);
    }

    @Test
    void Car_생성_테스트_실패(){
        assertThatThrownBy(() -> {
            Racing.createCars("INVALID_NAME,test2", condition);
        }).isInstanceOf(IllegalArgumentException.class);
    }
}
