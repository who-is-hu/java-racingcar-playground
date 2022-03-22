import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Cars {
    private List<Car> cars;

    public Cars(List<Car> cars) {
        this.cars = cars;
    }

    public int size() {
        return cars.size();
    }

    public Cars maxes() {
        Car mostMovedCar = cars.stream().max(Comparator.comparing(car -> car.getPosition())).get();
        return new Cars(cars.stream()
                .filter(car -> car.getPosition() >= mostMovedCar.getPosition())
                .collect(Collectors.toList())
        );
    }

    public Car get(int i) {
        return cars.get(i);
    }

    public void move() {
        cars.stream().forEach(car -> car.move());
    }

    public List<String> getNames(){
        return cars.stream().map(car -> car.getName())
                .collect(Collectors.toList());
    }
}
