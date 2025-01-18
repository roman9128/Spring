package rt.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import rt.domain.Car;

@Configuration
public class ProjConfig {

    @Bean("bmw")
    Car car1(){
        Car car = new Car();
        car.setModel("X1");
        car.setProducer("BMW");
        return car;
    }

    @Bean(name="Lada")
    Car car2(){
        Car car = new Car();
        car.setModel("Kalina");
        car.setProducer("Lada");
        return car;
    }

    @Bean
    @Primary
    Car car3(){
        Car car = new Car();
        car.setModel("Niva");
        car.setProducer("UAZ");
        return car;
    }

    @Bean
    String hello(){
        return "hello";
    }

    @Bean
    Integer ten(){
        return 10;
    }
}
