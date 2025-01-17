public class Main {
    public static void main(String[] args) {

        SingletonExample example1 = SingletonExample.getExample();
        example1.setName("First name");
        example1.doSmth();

        SingletonExample example2 = SingletonExample.getExample();
        example2.doSmth();

        System.out.println(example1);
        System.out.println(example2);

        // вывод в консоль одинаковый для двух примеров, вызван один и тот же объект
    }
}