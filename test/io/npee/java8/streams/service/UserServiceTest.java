package io.npee.java8.streams.service;

import static org.junit.jupiter.api.Assertions.*;

import io.npee.java8.streams.domain.User;
import io.npee.java8.streams.repository.UserRepository;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class UserServiceTest {

    UserRepository userRepository = new UserRepository();

    @BeforeEach
    void setUp() {
        for (int i = 1; i < 11; i++) {
            User user = new User(null, "user" + i, "user" + i + "@gmail.com", "사용자" + i);
            userRepository.save(user);
        }
    }

    @Test
    void findAllTest() {
        List<User> allUsers = userRepository.findAll();
        assertEquals(10, allUsers.size());
    }

}