package rt.task2;

import org.springframework.stereotype.Service;

import java.util.Random;

@Service
public class RandomService {

    private final Random random = new Random();

    public int sendNumber() {
        return random.nextInt(0, 101);
    }
    public int sendNumberWithin(int min, int max) {
        return random.nextInt(min, max + 1);
    }

}
