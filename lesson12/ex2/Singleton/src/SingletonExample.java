public class SingletonExample {
    private static SingletonExample example;
    private String name;

    private SingletonExample() {
    }

    public static SingletonExample getExample() {
        if (example == null) example = new SingletonExample();
        return example;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void doSmth(){
        System.out.println(name + " doing smth interesting");
    }
}