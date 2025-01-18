package rt.domain;

import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Lazy
public class DizEng implements iEngine {
    public DizEng() {
        System.out.println("new diz eng");
    }

    @Override
    public void start() {
        System.out.println("diz starts");
    }
}
