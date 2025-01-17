public class Lazer extends RobotDecorator {
    public Lazer(Robot robot) {
        super(robot, robot.getName() + " with lazer", "battle lazer robot");
    }
}
