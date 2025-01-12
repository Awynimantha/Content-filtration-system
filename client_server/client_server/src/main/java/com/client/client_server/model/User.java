package  com.client.client_server.model;

import lombok.Data;

@Data
public class User{
    public String userName;
    public String password;
    public String email;

    public User(String userName, String password, String email) {
        this.userName = userName;
        this.password = password;
        this.email = email;
    }

    public User(String userName, String email) {
          this.userName = userName;
          this.email = email;
    }
 
}
