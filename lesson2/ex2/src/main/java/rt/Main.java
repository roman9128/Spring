package rt;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import rt.config.ProjConfig;
import rt.domain.Car;
import rt.domain.Engine;

public class Main {
    public static void main(String[] args) {
        var context = new AnnotationConfigApplicationContext(ProjConfig.class);

        Car car = context.getBean("diz", Car.class);
//        Engine engine = context.getBean(Engine.class);

        System.out.println(car);
//        System.out.println(engine);
    }
}
