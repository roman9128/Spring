package rt.domain;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Car {
    private String model = "Lada";
    private String producer = "Kalina";
    @Autowired
    private iEngine engine;

    public Car(iEngine engine) {
        this.engine = engine;
        System.out.println("car starts");
    }

    public iEngine getEngine() {
        return engine;
    }

    public void setEngine(iEngine engine) {
        this.engine = engine;
    }

    @Override
    public String toString() {
        return "Car{" +
                "model='" + model + '\'' +
                ", producer='" + producer + '\'' +
                ", engine=" + engine +
                '}';
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getProducer() {
        return producer;
    }

    public void setProducer(String producer) {
        this.producer = producer;
    }

    public void go(){
        engine.start();
    }
}
