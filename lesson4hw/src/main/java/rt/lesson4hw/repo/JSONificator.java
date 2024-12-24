package rt.ex3.repo;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import rt.ex3.domain.User;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;

public class JSONificator {

    private static final String FILE_NAME = "users.json";
    private static final ObjectMapper OM = new ObjectMapper().registerModule(new JavaTimeModule());

    public static <T> void writeToJSON(T object) {
        OM.configure(SerializationFeature.INDENT_OUTPUT, true);
        try {
            OM.writeValue(new File(FILE_NAME), object);
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }


    public static ArrayList<User> readFromJSON() {
        File file = new File(FILE_NAME);
        if (file.exists()) {
            try {
                return OM.readValue(file, OM.getTypeFactory().constructCollectionType(ArrayList.class, User.class));
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
        }
        return null;
    }
}
