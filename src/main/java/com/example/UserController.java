package com.example;

import com.example.repository.UserRepository;
import io.micronaut.http.annotation.*;
import io.swagger.v3.oas.annotations.tags.Tag;

import java.util.List;


@Controller("/users")
@Tag(name = "User")
public class UserController  {

    private final UserRepository userRepository;

    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Get("/")
    public List<User> listUsers() {
        return userRepository.findAll();
    }

    @Post("/")
    public User createUser(@Body User user) {
        return userRepository.save(user);
    }


}
