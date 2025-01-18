package rt;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import rt.config.ProjConfig;
import rt.domain.Car;
import rt.domain.DizEng;

public class Main {
    public static void main(String[] args) {
        var context = new AnnotationConfigApplicationContext(ProjConfig.class);

        Car car = context.getBean(Car.class);
        car.go();
        System.out.println("============");
        DizEng de = context.getBean(DizEng.class);

    }
}
