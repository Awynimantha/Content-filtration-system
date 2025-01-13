package com.authetication.authenticator.repository;

import java.util.Optional;
import com.authetication.authenticator.model.User;

public interface UserRepository {
    public Iterable<User> getUsers();
    public Optional<User> getUserById(Long id);
    public User saveUser(User user);
    public void deleteUser(String id);
    public User getUserByName(String username);
}
