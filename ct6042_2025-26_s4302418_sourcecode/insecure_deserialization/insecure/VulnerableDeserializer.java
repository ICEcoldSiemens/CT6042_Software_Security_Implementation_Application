package insecure;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

// Deserialization of serialized malicious code.
    public class VulnerableDeserializer {
        public static void main(String[] args) {

            Object obj;

            // If the serialized malicious file exists, it will attempt to deserialize it.
            try (FileInputStream fileIn = new FileInputStream("malicious.ser");
                 ObjectInputStream in = new ObjectInputStream(fileIn)) {
                 obj = in.readObject();

                System.out.println("Object deserialized successfully."); // successful insecure deserialization
                        System.out.println("Object class: " + obj.getClass().getName());
            } catch (IOException | ClassNotFoundException i) {
                i.printStackTrace();
            }
        }
    }
