package rt.config;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import rt.domain.Car;
import rt.domain.Engine;

@Configuration
//@ComponentScan("rt.domain")
public class ProjConfig {

    @Bean
    Engine engineBenz() {
        Engine engine = new Engine();
        engine.setType("Benz");
        return engine;
    }

    @Bean
    @Primary
    Engine engineDiz() {
        Engine engine = new Engine();
        engine.setType("Dizel");
        return engine;
    }


    @Bean
    Car car1(@Qualifier("engineBenz") Engine engine) {
        Car car = new Car(engine);
//        car.setEngine(engine);
        car.setModel("Kalina");
        car.setProducer("Lada");
        return car;
    }

    @Bean("diz")
    Car car2(@Qualifier("engineDiz") Engine engine) {
        Car car = new Car(engine);
//        car.setEngine(engine);
        car.setModel("Kalina");
        car.setProducer("Lada");
        return car;
    }
}