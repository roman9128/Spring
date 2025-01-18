public class RobotImpl implements Robot {

    private String name;
    private String type;

    public RobotImpl(String name, String type) {
        this.name = name;
        this.type = type;
    }

    public RobotImpl() {
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
