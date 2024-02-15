package com.example.connection.repository;

import com.example.connection.entity.Users;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class UsersRepositoryTest {
    @Autowired
    UserRepository repository;

    @Test
    void DatabaseTest(){
        Users users = new Users();
        users.setUsername("Anika");
        users.setEmail("anika@gmail.com");
        users.setPassword("123XYZ");

        Users users2 = new Users();
        users2.setUsername("Tanha");
        users2.setEmail("tanha@gmail.com");
        users2.setPassword("123XYZA");

        repository.saveAll(List.of(users, users2));
    }

}