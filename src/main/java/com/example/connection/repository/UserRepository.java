package com.example.connection.repository;

import com.example.connection.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<Users, Long> {
    public Optional<Users> findUsersByEmail(String email);
}
