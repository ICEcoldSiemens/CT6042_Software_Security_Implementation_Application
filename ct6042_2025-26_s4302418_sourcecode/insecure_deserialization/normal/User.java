package normal;

import java.io.Serial;
import java.io.Serializable;

public class User implements Serializable {

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
        return "normal.User{username='" + username + "', role='" + role + "'}";
    }
}
