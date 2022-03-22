public class AlwaysFalseCondition implements MovingCondition {
    @Override
    public boolean canMove() {
        return false;
    }
}
