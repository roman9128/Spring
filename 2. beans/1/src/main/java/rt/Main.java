package rt;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import rt.config.ProjConfig;
import rt.domain.Car;

public class Main {
    public static void main(String[] args) {
        var context = new AnnotationConfigApplicationContext(ProjConfig.class);

        Car car = context.getBean(Car.class);
        System.out.println(car.getModel() + " " + car.getProducer());

        Car car2 = context.getBean("Lada", Car.class);
        System.out.println(car2.getModel() + " " + car2.getProducer());

        String s = context.getBean(String.class);
        System.out.println(s);

        Integer i = context.getBean(Integer.class);
        System.out.println(i);
    }
}
