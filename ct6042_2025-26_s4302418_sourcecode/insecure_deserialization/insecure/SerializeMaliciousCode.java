package insecure;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

    public class SerializeMaliciousCode {
        public static void main(String[] args) {
            MaliciousCode malicious = new MaliciousCode();

            try (FileOutputStream fileOut = new FileOutputStream("malicious.ser");
            ObjectOutputStream out = new ObjectOutputStream(fileOut)) {
                out.writeObject(malicious);

                System.out.println("Malicious object serialized successfully.");

            } catch (IOException i) {
                i.printStackTrace();
            }
        }
    }
