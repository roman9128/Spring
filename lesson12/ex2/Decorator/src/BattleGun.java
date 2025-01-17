public class BattleGun extends RobotDecorator {
    public BattleGun(Robot robot) {
        super(robot, "Armed " + robot.getName(), "battle robot");
    }
}