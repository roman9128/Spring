package rt.domain;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Primary
public class BenzEng implements iEngine {
    public BenzEng() {
        System.out.println("new benz eng");
    }

    @Override
    public void start() {
        System.out.println("benz starts");
    }
}
