public class Main {
    public static void main(String[] args) {

        int a = 50;
        int b = 2;

        Calculator calculator = new Calculator(new Multiplicator(), new Divider());
        calculator.multiply(a, b);
        calculator.divide(a, b);
    }
}