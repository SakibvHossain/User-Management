package com.example.connection.service;

import com.example.connection.dto.UsersDTO;
import com.example.connection.entity.Users;

import java.util.List;
import java.util.Optional;

public interface UserService {
    UsersDTO createUser(UsersDTO usersDTO);
    UsersDTO getUsers(Long id);
    List<UsersDTO> getAllUsers();
    UsersDTO updateUsers(UsersDTO usersDTO);
    void deleteUser(Long id);
}
