import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class CarTest {

    private MovingCondition alwaysTrueCondition = new AlwaysTrueCondition();

    @Test
    void 이름이_5글자_이하(){
        assertThatThrownBy(() -> {
            Car car = new Car("다섯글자넘어요",alwaysTrueCondition);
        }).isInstanceOf(IllegalArgumentException.class);

        assertThat(new Car("세글자", alwaysTrueCondition)).isInstanceOf(Car.class);
    }

    @Test
    void 전진조건_만족시_전진(){
        Car car = new Car("test1", alwaysTrueCondition);
        final int beforePos = car.getPosition();

        assertThat(car.move()).isEqualTo(true);
        assertThat(car.getPosition()).isEqualTo(beforePos + 1);
    }
}
