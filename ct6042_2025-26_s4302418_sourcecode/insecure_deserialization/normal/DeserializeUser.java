package normal;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

// Normal example of deserialization (assuming serialized file is legitimate)
public class DeserializeUser {
    public static void main(String[] args) {
        User user; // Null User object

        // attempts to locate and deserialize serialized User file.
        try (FileInputStream fileIn = new FileInputStream
                ("user.ser");
             ObjectInputStream in = new ObjectInputStream(fileIn)) {
            user = (User) in.readObject();

            // successfully deserialize the user object
            System.out.println("User file has deserialized successfully.");
                    System.out.println("User details: " + user);

                    // Catches exception if file not located or IO issues.
        } catch (IOException | ClassNotFoundException i) {
            i.printStackTrace();
        }
    }
}
