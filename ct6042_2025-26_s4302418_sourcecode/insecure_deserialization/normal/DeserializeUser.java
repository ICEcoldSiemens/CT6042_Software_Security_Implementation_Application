package normal;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

public class DeserializeUser {
    public static void main(String[] args) {
        User user = null;
        try (FileInputStream fileIn = new FileInputStream
                ("user.ser");
             ObjectInputStream in = new ObjectInputStream(fileIn)) {
            user = (User) in.readObject();
            System.out.println("normal.User object deserialized successfully.");
                    System.out.println("normal.User details: " + user);

        } catch (IOException | ClassNotFoundException i) {
            i.printStackTrace();
        }
    }
}
