package  com.authetication.authenticator.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
public class User{
    @JsonProperty("username")
    public String username;
    @JsonProperty("password")
    public String password;
    @JsonProperty("email")
    public String email;

    public User() {

    }

    public  User(String userName, String password, String email) {
        this.username = userName;
        this.password = password;
        this.email = email;
    }

    public User(String userName, String email) {
          this.username = userName;
          this.email = email;
    }
    
    public void setUsername(String username) {
      this.username = username;
    }
    
    public void setEmail(String email) {
      this.email = email;
    }

    public void setPassword(String password) {
      this.password = password;
    }

    public String getEmail() {
      return email;
    }
    
    public String getPassword() {
      return password;
    }

    public String getUsername() {
      return username;
    }
 
}
