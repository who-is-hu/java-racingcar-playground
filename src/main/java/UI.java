public class UI {
    public static void draw(Cars cars){
        for(int i = 0; i < cars.size(); i++) {
            UI.draw(cars.get(i));
        }
    }

    public static void draw(Car car){
        System.out.println(car.getName() +  " : " + "-".repeat(car.getPosition()));
    }

    public static void drawWinner(Cars winner) {
        System.out.println(String.join(",", winner.getNames()) + "가 우승!");
    }
}
