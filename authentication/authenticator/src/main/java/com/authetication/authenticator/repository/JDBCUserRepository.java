package com.authetication.authenticator.repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;
import com.authetication.authenticator.model.User;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class JDBCUserRepository implements UserRepository {

    public JdbcTemplate jdbcTemplate;   
    public JDBCUserRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public Iterable<User> getUsers() {
        return this.jdbcTemplate.query(
          "select username, email from client", this::mapToSecureUser
        ); 
    }

    public Optional<User> getUserById(Long id) {
        List<User> userList = jdbcTemplate.query(
          "select username, email from client where id=?",
          this::mapToSecureUser,
          id
          );   
        if(userList.size() == 0) {
            return Optional.empty();
        } 
        return Optional.of(userList.get(0));
        
    }

    public User saveUser(User user) {
        jdbcTemplate.update("insert into client(username, password, email) values(?, ? ,?)",
            user.getUsername(),
            user.getPassword(),
            user.getEmail()
        );
        return user;
    }
    
    public User getUserByName(String username) {
      List<User> userList = jdbcTemplate.query("select * from client where username=?", this::mapToWholeUser,username);
      if(userList.isEmpty()) {
        return null;
      }
      return userList.get(0);
    } 

    public void deleteUser(String id) {
        jdbcTemplate.update("delete * from client where id=?", id);
    }
    
    public User mapToWholeUser(ResultSet resultSet, int rowNum) throws SQLException{
          return new User(
            resultSet.getString("username"),
            resultSet.getString("password"),
            resultSet.getString("email")
          );
    }

    public User mapToSecureUser(ResultSet resultSet, int rowNum) throws SQLException{
          return new User(
            resultSet.getString("username"),
            resultSet.getString("email")
          );
    }
} 
