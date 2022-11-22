package com.optimus.nnlt.repository

import com.optimus.nnlt.model.User
import org.springframework.data.jpa.repository.JpaRepository

interface UserRepository extends JpaRepository<User, Integer>{
    Optional<User> findUserByEmail(String email);
}
