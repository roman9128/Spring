public class Calculator implements Printer {
    private Multiplicator multiplicator;
    private Divider divider;

    public Calculator(Multiplicator multiplicator, Divider divider) {
        this.multiplicator = multiplicator;
        this.divider = divider;
    }

    public void multiply(int a, int b){
        print(String.valueOf(multiplicator.multiply(a, b)));
    }

    public void divide(int a, int b){
        print(String.valueOf(divider.divide(a, b)));
    }

    @Override
    public void print(String text) {
        System.out.println(text);
    }
}