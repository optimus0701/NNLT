package com.optimus.nnlt.service

import com.optimus.nnlt.model.User
import org.springframework.stereotype.Service

@Service
interface UserService {
    List<User> getAllUser();
    void updateUser(User user);
    void removeUserById(int id);
    Optional<User> getUserById(int id);
    Optional<User> getUserByEmail(String email);
}
