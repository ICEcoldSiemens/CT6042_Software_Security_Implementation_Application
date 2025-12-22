package secure ;

import normal.User;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputFilter;
import java.io.ObjectInputStream;

// Applying basic validation techniques to secure deserialization.
public class SecureDeserializer {
    public static void main(String[] args) {
        Object obj;

        // attempts to deserialize serialized file. if malicious, it fails
        try (FileInputStream fileIn = new FileInputStream("user.ser");
             ObjectInputStream in = new ObjectInputStream(fileIn)) {

            // Filter serialized objects to accept specifics -> only allowing User class
            ObjectInputFilter filter = ObjectInputFilter.Config.createFilter("User;*!");
            in.setObjectInputFilter(filter);
            obj = in.readObject();

            // If legit serialized User file, it will successfully deserialize.
            if (obj instanceof User) {
                System.out.println("Object deserialized successfully.");
                System.out.println("Object class: " + obj.getClass().getName());
            } else {
                System.out.println("Invalid object type. Deserialization failed.");
            }

            // else, it will not deserialize.
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Deserialization failed: " + e.getMessage());
        }
    }
}


