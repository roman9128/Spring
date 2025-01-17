public class RobotDecorator extends RobotImpl implements Robot {

    private Robot robot;
    private String name;
    private String type;

    public RobotDecorator(Robot robot, String name, String type) {
        this.robot = robot;
        this.name = name;
        this.type = type;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getType() {
        return type;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "robot: name=" + name + ", type=" + type;
    }
}