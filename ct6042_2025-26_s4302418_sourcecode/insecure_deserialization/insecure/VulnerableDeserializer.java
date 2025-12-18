package insecure;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

    public class VulnerableDeserializer {
        public static void main(String[] args) {
            Object obj = null;
            try (FileInputStream fileIn = new FileInputStream("malicious.ser");
                 ObjectInputStream in = new ObjectInputStream(fileIn)) {
                 obj = in.readObject();

                System.out.println("Object deserialized successfully.");
                        System.out.println("Object class: " + obj.getClass().getName());
            } catch (IOException | ClassNotFoundException i) {
                i.printStackTrace();
            }
        }
    }
