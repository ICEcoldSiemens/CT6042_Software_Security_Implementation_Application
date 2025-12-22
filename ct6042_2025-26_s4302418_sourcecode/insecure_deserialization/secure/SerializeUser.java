package secure;

import normal.User;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

// Normal example of serialization (assuming object is legitimate)
public class SerializeUser {

    public static void main(String[] args){
        User user = new User("Manny", "Administrator"); // defines User object

        // attempts to serialize User object.
        try (FileOutputStream fileOut = new FileOutputStream("user.ser");

        ObjectOutputStream out = new ObjectOutputStream(fileOut)) {
            out.writeObject(user);
            System.out.println("User object serialized successfully.");

        } catch (IOException i) {
            i.printStackTrace();
        }
    }

}