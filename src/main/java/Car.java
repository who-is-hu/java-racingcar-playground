public class Car {
    private static final int NAME_LEN_LIMIT = 5;

    private String name;
    private int position = 0;
    private MovingCondition movingCondition;

    public Car(String name, MovingCondition movingCondition) {
        if (name.length() > NAME_LEN_LIMIT) {
            throw new IllegalArgumentException("너무 길어");
        }
        if (movingCondition == null) {
            throw new IllegalArgumentException("이동 조건이 필요해");
        }
        this.name = name;
        this.movingCondition = movingCondition;
    }


    public boolean move() {
        if (movingCondition.canMove()) {
            this.position++;
            return true;
        }
        return false;
    }

    public int getPosition() {
        return position;
    }

    public String getName() { return name; }
}
