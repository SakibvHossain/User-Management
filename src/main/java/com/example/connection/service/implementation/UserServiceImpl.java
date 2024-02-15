package com.example.connection.service.implementation;

import com.example.connection.dto.UsersDTO;
import com.example.connection.entity.Users;
import com.example.connection.exception.EmailNotFoundException;
import com.example.connection.exception.ResourceNotFoundException;
import com.example.connection.mapper.UserMapper;
import com.example.connection.repository.UserRepository;
import com.example.connection.service.UserService;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {
    private UserRepository repository;
    private ModelMapper modelMapper;
    @Override
    public UsersDTO createUser(UsersDTO usersDTO) {

        Optional<Users> userEmail = repository.findUsersByEmail(usersDTO.getEmail());
        if (userEmail.isPresent()){
            throw new EmailNotFoundException("Email already exists");
        }

        //userDTO to JPA entity
        //Users users = UserMapper.mapToUsers(usersDTO);
        Users users = modelMapper.map(usersDTO,Users.class);
        //Saved user

        Users savedUser = repository.save(users);
        //returning JPA entity to UsersDTO
        //UsersDTO userDTO = UserMapper.mapToUserDTO(savedUser);

        //Using model mapper
        //UsersDTO userDTO = modelMapper.map(users, UsersDTO.class);

        return modelMapper.map(users, UsersDTO.class);
    }

    @Override
    public UsersDTO getUsers(Long id) {
        Users getUser = repository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Users","id",id)
        );
        return modelMapper.map(getUser, UsersDTO.class);
    }

    @Override
    public List<UsersDTO> getAllUsers() {
        List<Users> users = repository.findAll();
        //return users.stream().map(UserMapper::mapToUserDTO).collect(Collectors.toList());
        return users.stream().map((user) -> modelMapper.map(user, UsersDTO.class)).collect(Collectors.toList());
    }

    @Override
    public UsersDTO updateUsers(UsersDTO usersDTO) {
        Users updated = repository.findById(usersDTO.getId()).orElseThrow(
                () -> new ResourceNotFoundException("Users", "id", usersDTO.getId())
        );
        updated.setUsername(usersDTO.getUsername());
        updated.setEmail(usersDTO.getEmail());
        updated.setPassword(usersDTO.getPassword());
        Users savedUser = repository.save(updated);

        return modelMapper.map(savedUser, UsersDTO.class);
    }

    @Override
    public void deleteUser(Long id) {
        Users getUser = repository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Users","id",id)
        );
        repository.deleteById(id);
    }

}
