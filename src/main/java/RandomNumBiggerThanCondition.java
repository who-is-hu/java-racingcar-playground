import java.util.Random;

public class RandomNumBiggerThanCondition implements MovingCondition {

    private int num;

    public RandomNumBiggerThanCondition(int num) {
        this.num = num;
    }

    @Override
    public boolean canMove() {
        int randomNum = new Random().nextInt(9) + 1;
        return randomNum > this.num;
    }
}
