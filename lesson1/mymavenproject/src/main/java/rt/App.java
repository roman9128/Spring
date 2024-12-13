package rt;

import com.google.common.base.Joiner;
import java.io.IOException;


/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) throws IOException {
        String[] words = {"hi", "you"};
        String msg = Joiner.on(", ").join(words);
        System.out.println(msg);
    }
}
