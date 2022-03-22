import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class CarsTest {

    @Test
    void maxes() {
        Car goCar = new Car("test1", new AlwaysTrueCondition());
        Car stopCar = new Car("test2", new AlwaysTrueCondition());
        goCar.move();

        List<Car> carList = Arrays.asList(goCar, stopCar);
        Cars maxes = new Cars(carList).maxes();

        assertThat(maxes.size()).isEqualTo(1);
        assertThat(maxes.get(0)).isEqualTo(goCar);
    }
}