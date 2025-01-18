package rt.domain;

import org.springframework.stereotype.Component;

//@Component
public class Engine {
    private String type = "benz";

    public Engine() {
        System.out.println("vzhuh-vzhuh");
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "Engine{" +
                "type='" + type + '\'' +
                '}';
    }
}
