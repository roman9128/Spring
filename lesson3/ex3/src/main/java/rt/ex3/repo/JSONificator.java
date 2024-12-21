package rt.ex3.repo;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

import java.io.File;
import java.io.IOException;
import java.util.Collection;

public class JSONificator {

    private static final String EXTENSION = ".json";
    private static final ObjectMapper OM = new ObjectMapper().registerModule(new JavaTimeModule());

    public static <T> void writeToJSON(T object, String fileName) {
        OM.configure(SerializationFeature.INDENT_OUTPUT, true);
        try {
            OM.writeValue(new File(fileName + EXTENSION), object);
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }


    public static <C extends Collection<?>> C readFromJSON(Class<C> collectionClass, Class<?> collectionObjectClass, String fileName) {
        File file = new File(fileName + EXTENSION);
        if (file.exists()) {
            try {
                return OM.readValue(file, OM.getTypeFactory().constructCollectionType(collectionClass, collectionObjectClass));
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
        }
        return null;
    }
}
