package insecure;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.Serializable;

// Class represents untrusted data, usually malicious statements
    public class MaliciousCode implements Serializable {

        private void readObject(ObjectInputStream ois) throws ClassNotFoundException, IOException {
            ois.defaultReadObject();

            // Code to be executed during deserialization
            System.out.println("Malicious code executed!");

            // Malicious statements inserted here
        }
    }
