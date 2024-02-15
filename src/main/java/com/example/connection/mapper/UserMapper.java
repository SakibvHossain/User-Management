package com.example.connection.mapper;

import com.example.connection.dto.UsersDTO;
import com.example.connection.entity.Users;

public class UserMapper {
    public static UsersDTO mapToUserDTO(Users users){
        UsersDTO usersDTO = new UsersDTO(
                users.getId(),
                users.getUsername(),
                users.getEmail(),
                users.getPassword()
        );
        return usersDTO;
    }

    public static Users mapToUsers(UsersDTO usersDTO){
        Users users = new Users(
                usersDTO.getId(),
                usersDTO.getUsername(),
                usersDTO.getEmail(),
                usersDTO.getPassword()
        );
        return users;
    }
}
