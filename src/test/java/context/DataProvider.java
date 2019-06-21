package context;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class DataProvider {

    private static List<User> users;

    public static void initializeUsers() throws IOException {
        users = Arrays.asList(new ObjectMapper()
            .readValue(new File("src/test/resources/users.json"), User[].class));
    }

    public static User getUser(String userName) {
        return users.stream()
            .filter(user -> user.getUserName().equals(userName))
            .findFirst()
            .orElseThrow(NullPointerException::new);
    }

}
