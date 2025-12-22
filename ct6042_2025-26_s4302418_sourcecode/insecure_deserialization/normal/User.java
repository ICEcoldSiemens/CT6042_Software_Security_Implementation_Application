package normal;

import java.io.Serial;
import java.io.Serializable;

// Defining a User class for serialization
public class User implements Serializable {

    // Variables and methods valid for serialization
    @Serial
    private static final long serialVersionUID = 1L;
    private String username;
    private String role;


    public User(String username, String role) {
        this.username = username;
        this.role = role;
    }

    // Getters
    public String getUsername() {
        return username;
    }
    public String getRole() {
        return role;
    }

    // toString method for easy printing
    @Override
    public String toString() {
        return "User{username='" + username + "', role='" + role + "'}";
    }
}
