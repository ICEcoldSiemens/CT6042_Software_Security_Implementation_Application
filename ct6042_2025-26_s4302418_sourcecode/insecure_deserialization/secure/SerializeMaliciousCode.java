package secure;

import insecure.MaliciousCode;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

// Serialization of malicious code
    public class SerializeMaliciousCode {


        public static void main(String[] args) {
            insecure.MaliciousCode malicious = new MaliciousCode(); // new malicious object

            // serializes the malicious code for transmission or storage
            try (FileOutputStream fileOut = new FileOutputStream("malicious.ser");
            ObjectOutputStream out = new ObjectOutputStream(fileOut)) {
                out.writeObject(malicious);

                System.out.println("Malicious object serialized successfully.");

            } catch (IOException i) {
                i.printStackTrace();
            }
        }
    }
