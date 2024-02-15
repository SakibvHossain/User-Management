package com.example.connection.controller;

import com.example.connection.dto.UsersDTO;
import com.example.connection.entity.Users;
import com.example.connection.exception.ErrorDetails;
import com.example.connection.exception.ResourceNotFoundException;
import com.example.connection.repository.UserRepository;
import com.example.connection.service.implementation.UserServiceImpl;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.WebRequest;

import java.time.LocalDateTime;
import java.util.List;
@Tag(
        name = "User Management REST API",
        description = "User Management REST API has CRUD operations like Create, Update, Delete, Read"
)
@RestController
@AllArgsConstructor
@RequestMapping("users")
public class UserController {
    private UserServiceImpl userService;

    //Creating new entity
    @Operation(
            summary = "Create User REST API",
            description = "The API will create new user"
    )
    @ApiResponse(
            responseCode = "201 Created!",
            description = "HTTP Status 201 Created"
    )
    @PostMapping("create")
    public ResponseEntity<UsersDTO> createUser(@RequestBody @Valid UsersDTO usersDTO){
        UsersDTO savedUsers = userService.createUser(usersDTO);
        return new ResponseEntity<>(savedUsers, HttpStatus.CREATED);
    }

    //Getting specific Entity
    @Operation(
            summary = "Get User REST API",
            description = "The API will get user by ID"
    )
    @ApiResponse(
            responseCode = "200 OK!",
            description = "HTTP Status 200 OK"
    )
    @GetMapping("{id}")
    public ResponseEntity<UsersDTO> getUser(@PathVariable("id") Long userId){
        UsersDTO getUsers = userService.getUsers(userId);
        return new ResponseEntity<>(getUsers, HttpStatus.OK);
    }

    //Getting All the entity
    @Operation(
            summary = "Get User REST API",
            description = "The API will get all the users"
    )
    @ApiResponse(
            responseCode = "200 OK!",
            description = "HTTP Status 200 OK"
    )
    @GetMapping("all")
    public ResponseEntity<List<UsersDTO>> getAllUsers(){
        List<UsersDTO> users = userService.getAllUsers();
        return new ResponseEntity<>(users, HttpStatus.OK);
    }

    //Updating Entity
    @Operation(
            summary = "Delete User REST API",
            description = "The API will delete user"
    )
    @ApiResponse(
            responseCode = "204 Accepted!",
            description = "HTTP Status 204 Accepted"
    )
    @PutMapping("updateUser/{id}")
    public ResponseEntity<UsersDTO> updateUsers(@RequestBody @Valid UsersDTO users, @PathVariable("id") Long userId){
        users.setId(userId);
        UsersDTO users1 = userService.updateUsers(users);
        return new ResponseEntity<>(users1, HttpStatus.ACCEPTED);
    }

    //Deleting Specific Entity
    @Operation(
            summary = "Delete User REST API",
            description = "The API will delete user by ID"
    )
    @ApiResponse(
            responseCode = "204 Accepted!",
            description = "HTTP Status 204 Accepted"
    )
    @DeleteMapping("delete/{id}")
    public ResponseEntity<String> deleteUser(@PathVariable("id") Long userId){
        userService.deleteUser(userId);
    return new ResponseEntity<>("Users successfully deleted!", HttpStatus.ACCEPTED);
    }

//    @ExceptionHandler(ResourceNotFoundException.class)
//    public ResponseEntity<ErrorDetails> handleResourceNotFoundException(ResourceNotFoundException exception,
//                                                                        WebRequest webRequest){
//        ErrorDetails details = new ErrorDetails(
//                LocalDateTime.now(),
//                exception.getMessage(),
//                webRequest.getDescription(false),
//                "User_Not_Found"
//        );
//
//        return new ResponseEntity<>(details, HttpStatus.NOT_FOUND);
//    }
}
