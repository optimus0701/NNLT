package com.optimus.nnlt.service.impl

import com.optimus.nnlt.model.User
import com.optimus.nnlt.repository.UserRepository
import com.optimus.nnlt.service.UserService
import org.springframework.beans.factory.annotation.Autowired

class UserServiceImpl implements UserService {
    @Autowired
    UserRepository userRepository;
    @Override
    List<User> getAllUser() {
        return userRepository.findAll();
    }

    @Override
    void updateUser(User user) {
        userRepository.save(user);
    }

    @Override
    void removeUserById(int id) {
        userRepository.deleteById(id);
    }

    @Override
    Optional<User> getUserById(int id) {
        return userRepository.findById(id);
    }

    @Override
    Optional<User> getUserByEmail(String email) {
        return userRepository.findUserByEmail(email);
    }
}
