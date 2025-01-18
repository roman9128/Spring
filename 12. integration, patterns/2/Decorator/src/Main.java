public class Main {
    public static void main(String[] args) {

        Robot regularRobot = new RobotImpl("Wall-e", "basic");
        System.out.println(regularRobot);

        Robot battleRobot = new BattleGun(regularRobot);
        System.out.println(battleRobot);

        Robot lazerBattleRobot = new Lazer(battleRobot);
        System.out.println(lazerBattleRobot);

        Robot lazerRobot = new Lazer(regularRobot);
        System.out.println(lazerRobot);
    }
}