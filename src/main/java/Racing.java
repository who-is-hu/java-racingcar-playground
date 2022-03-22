import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Racing {
    private MovingCondition movingCondition;
    private Cars cars;
    private int loopTimes;

    public Racing(String carNames, int loopTimes, MovingCondition movingCondition) {
        this.movingCondition = movingCondition;
        this.cars = createCars(carNames, movingCondition);
        this.loopTimes = loopTimes;
    }

    static Cars createCars(String carNames, MovingCondition movingCondition) {
        List<Car> carList = Arrays.stream(carNames.split(","))
                .map(name -> new Car(name, movingCondition))
                .collect(Collectors.toList());
        return new Cars(carList);
    }

    public Cars getWinner() {
        return cars.maxes();
    }

    public void race() {
        for(int i = 0; i < loopTimes; i++) {
            cars.move();
            UI.draw(cars);
            System.out.println("================");
        }
    }
}
