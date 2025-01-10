package com.client.client_server.repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

import org.springframework.jdbc.core.JdbcTemplate;

import com.client.client_server.model.User;

public class JDBCUserRepository implements UserRepository {

    public JdbcTemplate jdbcTemplate;   
    public JDBCUserRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public Iterable<User> getUsers() {
        return this.jdbcTemplate.query(
          "select username, email from user", this::mapToSecureUser
        ); 
    }

    public Optional<User> getUserById(String id) {
        List<User> userList = jdbcTemplate.query(
          "select username, email from user where id=?",
          this::mapToSecureUser,
          id
          );   
        if(userList.size() == 0) {
            return Optional.empty();
        } 
        return Optional.of(userList.get(0));
        
    }

    public User saveUser(User user) {
        jdbcTemplate.query("insert into user (username, password, email) values(?, ? ,?)",
            user.userName(),
            user.getPassword(),
            user.getEmail()
        );
    }

    public void deleteUser(String id) {

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
