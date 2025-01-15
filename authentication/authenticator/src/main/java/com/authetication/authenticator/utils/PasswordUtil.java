package  com.authetication.authenticator.utils;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class PasswordUtil {
  private PasswordEncoder passwordEncoder;
  public PasswordUtil(PasswordEncoder passwordEncoder) {
    this.passwordEncoder = passwordEncoder;
  }

  public String encode(String str){
    if(str.isEmpty()) {
      return "";
    } 
    return passwordEncoder.encode(str);
  }
}
