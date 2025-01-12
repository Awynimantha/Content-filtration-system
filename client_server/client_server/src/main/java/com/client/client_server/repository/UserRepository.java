package com.client.client_server.repository;

import java.util.Optional;
import com.client.client_server.model.User;

public interface UserRepository {
    public Iterable<User> getUsers();
    public Optional<User> getUserById(Long id);
    public User saveUser(User user);
    public void deleteUser(String id);
    
}
