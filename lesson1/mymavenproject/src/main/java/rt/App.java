package rt;

import com.google.common.base.Joiner;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        String[] words = {"hi", "you"};
        String msg = Joiner.on(", ").join(words);
        System.out.println(msg);
    }
}
